package com.backend.apis;

import com.backend.helpers.common.StatusCode;
import com.backend.helpers.endpoints.Service;
import com.backend.helpers.restassured.RestClient;
import com.backend.pojo.GenderApiResponse;
import com.jayway.restassured.builder.RequestSpecBuilder;


import static com.backend.helpers.restassured.RequestType.*;

public class GenderAPIs {

    Logger log = Logger.getLogger(GenderAPIs.class);

    final RestClient restClient = new RestClient();

    public GenderApiResponse getGenderByName(final String name, final StatusCode statusCode) {

        log.info(String.format("sending request with name as : {}", name));
        final RequestSpecBuilder request = new RequestSpecBuilder()
                .setBaseUri(Service.GENDER.getService())
                .addQueryParam("name", name);
                // if you have headers
                //.addHeaders(Util.getHeaders());

        return restClient.getResponse(GET, request.build(), GenderApiResponse.class, statusCode.getCode());
    }
}
