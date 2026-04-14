package com.backend.helpers.restassured;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

@Log4j2
public class RestClient {

    public Response getResponse(final RequestType requestType,
                                final RequestSpecification reqSpecification,
                                final Integer expectedStatusCode){
        RestAssured.defaultParser = Parser.JSON;
        given().contentType("application/json\r\n");
        Response response = null;
        try {
            switch (requestType) {
                case GET:
                    response = given().spec(reqSpecification).when().log().all().get().then().extract().response();
                    break;
                case PUT:
                    response = given().spec(reqSpecification).when().log().all().put().then().extract().response();
                    break;
                case POST:
                    response = given().spec(reqSpecification).when().log().all().post().then().extract().response();
                    break;
                case PATCH:
                    response = given().spec(reqSpecification).when().log().all().patch().then().extract().response();
                    break;
                case DELETE:
                    response = given().spec(reqSpecification).when().log().all().delete().then().extract().response();
                    break;
            }
        } catch (Exception e) {
            log.error("Exception Occurred : {}", e.getCause().getMessage());
            Assert.fail("API call failure");
        }
        log.info(response.prettyPrint());
        if(response.statusCode() != expectedStatusCode) {
            log.error("Status code received : {}", response.statusCode());
            Assert.fail("status code doesn't match");
        }
        if(response.getBody().asString().isEmpty()){
            log.warn("Response body is empty, returning null response");
            return null;
        }
        return response;
    }
}