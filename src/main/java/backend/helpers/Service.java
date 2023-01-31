package backend.helpers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Service {
    @Step("GET {endpoint")
    public static Response getResponseCustomMethod(String endpoint) {
        return given()
                .get(endpoint)
                .then()
                .extract().response();
    }

    @Step("GET {endpoint}")
    public static <T> T getToPojo(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().as(pojoClass);
    }

    // Уточняем через JSONPath что мы извлекаем в POJO (к примеру один json object)
    @Step("GET {endpoint}")
    public static <T> T getToPojoJsonPath(String endpoint, String jsonPath, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getObject(jsonPath, pojoClass);
    }

    // Получаем список JSON объектов
    @Step("GET {endpoint}")
    public static <T> List<T> getToListPojoJsonPathData(String endpoint, Class<T> pojoClass) {
        return given()
                .get(endpoint)
                .then()
                .extract().body().jsonPath().getList("data", pojoClass);
    }
}
