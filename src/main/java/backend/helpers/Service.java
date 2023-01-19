package backend.helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Service {
    @Step("GET {endpoint")
    public static Response getResponseCustomMethod(String endpoint) {
        return given()
                .get(endpoint)
                .then()
                .extract().response();
    }
}
