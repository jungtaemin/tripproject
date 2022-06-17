package com.tripproject.user.application.port.in.response.userInfo;

import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes;


    public GoogleUserInfo(OAuth2User oAuth2User) {
        this.attributes = oAuth2User.getAttributes();
    }

    @Override
    public String getProviderId() {
        return (String)attributes.get("sub");
    }

    @Override
    public String getProvider() {
        return ProviderType.GOOGLE.getValue();
    }

    @Override
    public String getUserName() {
        return attributes.get("name") + "#" + ((String)attributes.get("sub")).substring(0,5);
    }

    @Override
    public String getEmail() {
        return (String)attributes.get("email");
    }

    @Override
    public String getPicture() {
        return (String)attributes.get("picture");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
