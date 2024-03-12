package com.example.demoBankApp.config;

import lombok.Getter;

@Getter
public enum AuthUrl {

    ADMIN("ADMIN", new String[] {
            "/api/v1/bankApp/account/save",
            "/api/v1/bankApp/branch/save",
            "/api/v1/bankApp/account/filter",
            "/api/v1/bankApp/client/all"

    }),
    USER("USER", new String[] {
            "/api/v1/bankApp/account/filter",
            "/api/v1/bankApp/client/all"
    }),
    PERMIT_ALL(null,new String[] {
            "/api/v1/bankApp/auth/login",
            "/api/v1/bankApp/client/register"
            ,"/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/swagger-ui/**",
            "/swagger-ui.html"
    });

    private final String[] urls;
    private final String role;

    AuthUrl(String role,String[] urls) {
        this.role=role;
        this.urls = urls;
    }

}
