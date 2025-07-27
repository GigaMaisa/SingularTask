package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static constants.Constants.BASE_URL;

public abstract class BaseApi {
    protected RequestSpecification baseRequest() {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .noContentType();
    }

    protected Response execute(RequestSpecification spec, String endpoint) {
        return spec
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}