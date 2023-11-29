package com.bos.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class ClientConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (authorize) -> {
                    authorize.requestMatchers(new AntPathRequestMatcher("/")).permitAll();
                    authorize.anyRequest().authenticated();
                });
        http.oauth2Login((oauth2) -> oauth2.defaultSuccessUrl("/")); // <1> 인가처리만 해줌
        http.oauth2Client(Customizer.withDefaults()); // <2> 인가처리 및 엔드유저의 인증처리도 포함

        return http.build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
