package com.backend.helpers.endpoints;

public final class Endpoints {

    public enum DataUSA {

        data("/api/data");

        private final String uri;

        DataUSA(String name) {
            this.uri = name;
        }

        public String getService() {
            return uri;
        }
    }

}
