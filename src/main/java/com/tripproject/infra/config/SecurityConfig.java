package com.tripproject.infra.config;

import com.tripproject.user.application.Oauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@RequiredArgsConstructor

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Oauth2UserService oauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              //인가
              .authorizeRequests()
              .antMatchers("/article/**").access("hasRole('ROLE_USER')")
              .anyRequest().permitAll()

              .and()
              .logout()
              .deleteCookies("JSESSIONID")
              .logoutSuccessUrl("/")



              //로그인
              .and()
              .oauth2Login()
              .loginPage("/oauth2/authorization/google")
              .userInfoEndpoint()
              .userService(oauth2UserService);


    }
}
