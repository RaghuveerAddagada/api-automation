package com.backend.helpers.common;

public enum APIToken {

    DEV_APPLICATION_TOKEN("dev-app");


    private final String token;

    APIToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
