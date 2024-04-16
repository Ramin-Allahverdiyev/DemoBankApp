package com.example.demoBankApp.config;

import com.example.demoBankApp.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(CsrfConfigurer::disable);
        httpSecurity.authorizeHttpRequests(request ->
                        request
//                                .requestMatchers(AuthUrl.PERMIT_ALL.getUrls())
//                                .permitAll()
//                                .requestMatchers(AuthUrl.ADMIN.getUrls()).hasAuthority(AuthUrl.ADMIN.getRole())
//                                .requestMatchers(AuthUrl.USER.getUrls()).hasAuthority(AuthUrl.USER.getRole())
//                                .anyRequest()
//                                .authenticated())
                                .anyRequest().permitAll())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        httpSecurity.headers((headers) -> headers.disable());
        return httpSecurity.build();
    }





}
