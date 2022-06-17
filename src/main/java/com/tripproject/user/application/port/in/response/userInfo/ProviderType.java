package com.tripproject.user.application.port.in.response.userInfo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProviderType {

    NAVER("naver"),
    GOOGLE("google");

    private final String value;
}
