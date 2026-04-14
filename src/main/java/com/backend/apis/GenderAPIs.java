package com.backend.apis;

import com.backend.helpers.restassured.RequestType;
import io.restassured.builder.RequestSpecBuilder;

import com.backend.helpers.common.StatusCode;
import com.backend.helpers.endpoints.Service;
import com.backend.helpers.restassured.RestClient;
import com.backend.pojo.GenderApiResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GenderAPIs {

    final RestClient restClient = new RestClient();

    public GenderApiResponse getGenderByName(final String name, final StatusCode statusCode) {

        log.info("Sending request with name as : {}", name);
        final RequestSpecBuilder request = new RequestSpecBuilder()
                .setBaseUri(Service.GENDER.getService())
                .addQueryParam("name", name);
        // if you have headers
        //.addHeaders(Util.getHeaders());
        return restClient.getResponse(RequestType.GET, request.build(), statusCode.getCode()).as(GenderApiResponse.class);
    }
}
