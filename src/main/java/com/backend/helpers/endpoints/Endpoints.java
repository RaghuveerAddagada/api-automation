package com.backend.helpers.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

public final class Endpoints {

    @AllArgsConstructor
    @Getter
    public enum DataUSA {

        data("/api/data");

        private final String uri;
    }

}
