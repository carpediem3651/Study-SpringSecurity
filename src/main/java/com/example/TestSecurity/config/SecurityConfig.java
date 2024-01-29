package com.example.TestSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // 권한 설정
        http
                .authorizeHttpRequests((auth) -> auth
                        //경로에 접근제한 설정
                        //상당부터 접급제한 설정됨. 순서 유의할 것.
                        .requestMatchers("/", "/login").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
                        // .authenticated() 로그인 된 사용자만 접근가능
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
