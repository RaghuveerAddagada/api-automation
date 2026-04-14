package com.backend.helpers.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Service {

    GENDER("https://api.genderize.io/"),
    DATA_USA("https://datausa.io/");

    private final String service;
}
