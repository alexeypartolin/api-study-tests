package backend.helpers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static backend.helpers.CustomAllureRestListener.withCustomTemplates;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class SpecConfigurator {
    private static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .build()
                .filters(
                        new RequestLoggingFilter(LogDetail.URI),
                        new RequestLoggingFilter(LogDetail.BODY),
                        new ResponseLoggingFilter(LogDetail.BODY));
    }

    private static ResponseSpecification responseSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(anyOf(
                        is(200),
                        is(201)
                ))
                .build();
    }

    private static void installSpecWrapper(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    public static void installSpec200() {
        installSpecWrapper(requestSpec(), responseSpec200());

        if (RestAssured.filters().isEmpty()) {
            RestAssured.filters(withCustomTemplates());
        }
    }

    // Сделать 404

}
