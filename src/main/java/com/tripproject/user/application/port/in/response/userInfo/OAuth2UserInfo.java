package com.tripproject.user.application.port.in.response.userInfo;

import com.tripproject.user.domain.Role;
import com.tripproject.user.domain.User;

import java.util.Map;

public interface OAuth2UserInfo {

    String getProviderId();

    String getProvider();

    String getUserName();

    String getEmail();

    String getPicture();

    Map<String, Object> getAttributes();

    default User toEntity(){

        return User.builder()
                .providerId(this.getProviderId())
                .provider(this.getProvider())
                .userId(this.getProviderId())
                .userName(this.getUserName())
                .email(this.getEmail())
                .picURI(this.getPicture())
                .role(Role.USER)
                .build();
    }

}
