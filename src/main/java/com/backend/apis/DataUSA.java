package com.backend.apis;

import com.backend.helpers.common.StatusCode;
import com.backend.helpers.endpoints.Endpoints;
import com.backend.helpers.endpoints.Service;
import com.backend.helpers.restassured.RestClient;
import com.backend.pojo.DataUSAResponse;
import io.restassured.builder.RequestSpecBuilder;

import static com.backend.helpers.restassured.RequestType.*;

public class DataUSA {

    final RestClient restClient = new RestClient();

    public DataUSAResponse getDataOfUSA(final String drillDown, final String measures, final StatusCode statusCode) {

        //hitting this APi https://datausa.io/api/data?drilldowns=Nation&measures=Population

        final RequestSpecBuilder request = new RequestSpecBuilder()
                .setBaseUri(Service.DATA_USA.getService())
                .setBasePath(Endpoints.DataUSA.data.getService())
                .addQueryParam("drilldowns", drillDown)
                .addQueryParam("measures", measures);

        return restClient.getResponse(GET, request.build(), DataUSAResponse.class, statusCode.getCode());
    }
}
