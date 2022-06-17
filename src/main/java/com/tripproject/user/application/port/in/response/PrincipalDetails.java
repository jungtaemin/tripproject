package com.tripproject.user.application.port.in.response;

import com.tripproject.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class PrincipalDetails implements OAuth2User {


    private Map<String, Object> attributes;
    private User user;

    public  PrincipalDetails( User user,Map<String, Object> attributes) {
        this.attributes = attributes;
        this.user = user;
    }

    @Override
    public String getName() {
       return user.getUserName();
    }

    public Long getId(){
        return user.getId();
    }

    public String getPicURI(){
        return user.getPicURI();
    }

    public User getUser(){
        return user;
    }


    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getValue()));
        return  authorities;

    }
}
