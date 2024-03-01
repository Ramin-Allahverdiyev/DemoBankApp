package com.example.demoBankApp.Validation;

public final class RegexPatterns {
    public static final String EMAIL = "^(.+)@(.+)$";
    public static final String PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{5,}$";

    private RegexPatterns() {
    }
}
