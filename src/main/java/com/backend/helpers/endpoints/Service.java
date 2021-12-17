package com.backend.helpers.endpoints;

public enum Service {

    GENDER("https://api.genderize.io/"),
    DATA_USA("https://datausa.io/");

    private final String service;

    Service(String name) {
        this.service = name;
    }

    public String getService() {
        return service;
    }
}
