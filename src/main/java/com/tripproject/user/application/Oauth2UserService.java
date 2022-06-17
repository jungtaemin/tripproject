package com.tripproject.user.application;

import com.tripproject.user.adapter.out.UserRepository;
import com.tripproject.user.adapter.out.UserRepositoryAdapter;
import com.tripproject.user.application.port.in.response.PrincipalDetails;
import com.tripproject.user.application.port.in.response.userInfo.OAuth2UserInfo;
import com.tripproject.user.application.port.out.UserRepositoryPort;
import com.tripproject.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor

@Service
@Transactional
public class Oauth2UserService extends DefaultOAuth2UserService {

    private final UserInfoFactory userInfoFactory;
    private final UserRepositoryPort userRepositoryPort;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        var oAuth2User = super.loadUser(userRequest);
        var userInfo =
                userInfoFactory.createUserInfo(userRequest.getClientRegistration().getRegistrationId(), oAuth2User);
        var user = getOrJoinMember(userInfo);
        return new PrincipalDetails(user, userInfo.getAttributes());
    }

    private User getOrJoinMember(OAuth2UserInfo userInfo) {
        var user = userRepositoryPort.findByUserId(userInfo.getProviderId())
                .orElseGet(() -> signUpNewMember(userInfo));
        user.renewUsername(userInfo.getUserName());
        return user;
    }

    private User signUpNewMember(OAuth2UserInfo userInfo) {
        userRepositoryPort.findByEmail(userInfo.getEmail())
                .ifPresent(alreadyMember -> {
                    throw new OAuth2AuthenticationException("duplicateEmail");});
        var newMember = userInfo.toEntity();
        userRepositoryPort.save(newMember);
        return newMember;
    }
}
