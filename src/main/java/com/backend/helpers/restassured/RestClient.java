package com.backend.helpers.restassured;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class RestClient {

    private static final Logger log = LogManager.getLogger(RestClient.class);

    public <T>T getResponse(final RequestType requestType, final RequestSpecification reqSpecification, final Class<T> responseClass, final Integer expectedStatusCode){
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
            log.error("Exception Occurred : " + e.getCause());
            Assert.fail("API call failure");
        }
        log.debug(response.prettyPrint());
        if(response.statusCode() != expectedStatusCode) {
            log.error("status code received : " + response.statusCode());
            Assert.fail("status code doesn't match");
        }
        if(response.getBody().asString().equals("")){
            log.warn("response body is empty, returning null response");
            return null;
        }
        return response.as(responseClass);
    }

    public Response getResponse(final RequestType requestType, final RequestSpecification reqSpecification, final Integer expectedStatusCode){
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
            log.error("Exception Occurred : " + e.getCause());
            Assert.fail("API call failure");
        }
        log.info(response.prettyPrint());
        if(response.statusCode() != expectedStatusCode) {
            log.error("status code received : " + response.statusCode());
            Assert.fail("status code doesn't match");
        }
        if(response.getBody().asString().equals("")){
            log.warn("response body is empty, returning null response");
            return null;
        }
        return response;
    }
}