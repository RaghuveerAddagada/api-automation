package com.backend.apis;

import com.backend.helpers.common.StatusCode;
import com.backend.helpers.endpoints.Service;
import com.backend.helpers.restassured.RestClient;
import com.backend.pojo.GenderApiResponse;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;

import static com.backend.helpers.restassured.RequestType.*;

public class GenderAPIs {

    final RestClient restClient = new RestClient();

    public GenderApiResponse getGenderByName(final String name, final StatusCode statusCode) {

        // this is the end point https://api.genderize.io/?name=luc
        final RequestSpecBuilder request = new RequestSpecBuilder()
                .setBaseUri(Service.GENDER.getService())
                .addQueryParam("name", name);
                // if you have headers
                //.addHeaders(Util.getHeaders());

        return restClient.getResponse(GET, request.build(), GenderApiResponse.class, statusCode.getCode());
    }
}
