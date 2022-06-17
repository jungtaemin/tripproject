package com.tripproject.user.application;

import com.tripproject.user.application.port.in.response.userInfo.GoogleUserInfo;
import com.tripproject.user.application.port.in.response.userInfo.NaverUserInfo;
import com.tripproject.user.application.port.in.response.userInfo.OAuth2UserInfo;
import com.tripproject.user.application.port.in.response.userInfo.ProviderType;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class UserInfoFactory {

    private final static  Map<ProviderType, Function<OAuth2User, OAuth2UserInfo>> userInfo;
    static{
        userInfo = Collections.synchronizedMap(new EnumMap<>(ProviderType.class));
        userInfo.put(ProviderType.GOOGLE, GoogleUserInfo::new);
        //userInfo.put(ProviderType.NAVER, NaverUserInfo::new);
    }


    // String 을 map으로 컨버팅 ㅇ<
    private final static Map<String ,ProviderType> stringTOMap;
    static{
        stringTOMap = Collections.synchronizedMap(Stream.of(ProviderType.values())
                .collect(Collectors.toMap(ProviderType::getValue,providerType -> providerType))
        );
    }




    public OAuth2UserInfo createUserInfo(String registrationId, OAuth2User oAuth2User) {
        Optional<ProviderType> enumProviderType = userInfoEnum(registrationId);
        return userInfo.get(enumProviderType.orElseThrow(NotSupportProviderException::new))
                .apply(oAuth2User);

    }

    private Optional<ProviderType> userInfoEnum(String registrationId) {
       return Optional.ofNullable(stringTOMap.get(registrationId));
    }


}
