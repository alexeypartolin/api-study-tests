package backend;

import backend.assertions.AssertUsers;
import backend.helpers.Endpoints;
import backend.helpers.Service;
import backend.helpers.SpecConfigurator;
import backend.method.MethodsReqresController;
import backend.pojo.reqrespojocontrollers.getlistusersfrompage.DataJSONArray;
import backend.pojo.reqrespojocontrollers.getlistusersfrompage.PojoResUsers;
import backend.pojo.reqrespojocontrollers.postcreatenewuser.PojoResCreateUser;
import dev.failsafe.internal.util.Assert;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class ReqresApiTests {
//    private final MethodsReqresController methodsReqresController = new MethodsReqresController();
//    @Test
//    @DisplayName("Получение списка пользователей на странице и проверка id первого пользователя")
//    public void getListOfUsersByPage() {
//        SpecConfigurator.installSpec200();
//
//        var listOfUsers = methodsReqresController.methodGetListUsersFromPage(2);
//
//        AssertUsers assertUsers = new AssertUsers(listOfUsers);
//        assertUsers.assertUsersOnPage();
//    }
//
//    @Test
//    @DisplayName("2")
//    public void getListOfUsersByPage2() {
//        SpecConfigurator.installSpec200();
//
//        var pojo = Service.getToPojo(Endpoints.Get.getListUsersFromPage(2), PojoResUsers.class);
//        System.out.println(pojo.getVsego());
//
////        var response = methodsReqresController.methodGetListUsersFromPage(2);
////        int id = response.jsonPath().get("data[0].id");
////        System.out.println(id);
//
////        var userId7 = Service.getToPojoJsonPath(
////                Endpoints.Get.getListUsersFromPage(2),
////                "data[0]",
////                DataJSONArray.class);
////
////        System.out.println(userId7.getEmail());
//
//        var listOfUsers = Service.getToListPojoJsonPathData(Endpoints.Get.getListUsersFromPage(2), DataJSONArray.class);
//        System.out.println(listOfUsers.get(3).getFirst_name());
//    }

//    @Test
//    @DisplayName("Коллекция тестов")
//    public void CollectionOfTestExamples() {
//        SpecConfigurator.installSpec200();
//        // 1 Вариант (Method + POJO + assert in test)
//
//        var response = methodsReqresController.methodGetListUsersFromPage(2);
//        var pojo = response.as(PojoResUsers.class);
//        var actualResult = pojo.getData().get(0).getFirst_name();
//        var expectedResult = "Michael";
//
//        Assertions.assertThat(expectedResult).isEqualTo(expectedResult);
//
//        // 2 Вариант (Method + POJO + assert class)
//
//        var response2 = methodsReqresController.methodGetListUsersFromPage(2);
//        AssertUsers assertUsers = new AssertUsers(response2);
//        assertUsers.assertUsersOnPage();
//
//        // 3 Вариант (Service + T method(endpoint, pojo.class) + assert in test)
//
//        var pojo2 = Service.getToPojo(Endpoints.Get.getListUsersFromPage(2), PojoResUsers.class);
//        Assertions.assertThat(pojo2.getData().get(0).getId()).isEqualTo(7);
//
//         // 4 Вариант (Method + jsonPath + assert in test)
//
//        var response4 = methodsReqresController.methodGetListUsersFromPage(2);
//        var actualResult4 = response4.jsonPath().get("data[5].id");
//        var expectedResult4 = 12;
//
//        Assertions.assertThat(actualResult4).isEqualTo(expectedResult4);
//
//        // 5 Вариант (Method + jsonPath + assert in class)
//
//        var response5 = methodsReqresController.methodGetListUsersFromPage(2);
//        AssertUsers assertUsers5 = new AssertUsers(response5);
//        assertUsers5.assertUserIdInData();
//
//        // 6 Вариант (T method с конкретным user из data (endpoint, jsonPath, pojo.class)
//
//    }

    private final MethodsReqresController methodsReqresController = new MethodsReqresController();
    @Test
    @DisplayName("Коллекция GET-тестов с разными подходами")
    public void CollectionOfDifferentGetTests() {
        // Ниже представлены разные методы написания АТ (GET) на примере простых тестов

        SpecConfigurator.installSpec200();

        // 1 Вариант (Service in method class + POJO + assert in test)
        var response1 = methodsReqresController.methodGetListUsersFromPage(2);
        PojoResUsers pojo1 = response1.as(PojoResUsers.class);

        var actualResult1 = pojo1.getData().get(0).getFirst_name();
        var expectedResult1 = "Michael";

        Assertions.assertThat(expectedResult1).isEqualTo(actualResult1);

        // 2 Вариант (Service + POJO + assert class)
        var endpoint2 = Endpoints.Get.getListUsersFromPage(2);
        var response2 = Service.getResponseCustomMethod(endpoint2);
        AssertUsers assertUsers = new AssertUsers(response2);
        assertUsers.assertUsersOnPage();

        // 3 Вариант (Service + JSONPath + assert in test)
        var endpoint3 = Endpoints.Get.getListUsersFromPage(2);
        Response response3 = Service.getResponseCustomMethod(endpoint3);

        var actualResult3 = response3.jsonPath().get("data[0].id");
        var expectedResult3 = 7;

        Assertions.assertThat(expectedResult3).isEqualTo(actualResult3);

        // 4 Вариант (T service method(endpoint, pojo.class) + assert in test)

        var endpoint4 = Endpoints.Get.getListUsersFromPage(2);
        var pojo4 = Service.getToPojo(endpoint4, PojoResUsers.class);

        var actualResult4 = pojo4.getData().get(0).getFirst_name();
        var expectedResult4 = "Michael";

        Assertions.assertThat(expectedResult4).isEqualTo(actualResult4);

        // 5 Вариант (T method(endpoint, jsonPath, pojo.class) + assert in test)
        var pojo5 = Service.getToPojoJsonPath(
                Endpoints.Get.getListUsersFromPage(2),
                "data[0]",
                DataJSONArray.class);

        var actualResult5 = pojo5.getId();
        var expectedResult5 = 7;

        Assertions.assertThat(expectedResult5).isEqualTo(actualResult5);

        // 6 Вариант (T method(enpoint, pojo.class) + assert in test)
        var pojo6 = Service.getToListPojoJsonPathData(
                Endpoints.Get.getListUsersFromPage(2),
                DataJSONArray.class
        );

        var expectedResult6 = pojo6.get(3).getEmail();
        var actualResult6 = "byron.fields@reqres.in";

        Assertions.assertThat(expectedResult6).isEqualTo(actualResult6);
    }

    @Test
    @DisplayName("Коллекция POST-тестов с разными подходами")
    public void CollectionOfDifferentPostTests() {
        // Ниже представлены разные методы написания АТ (POST) на примере простых тестов

        SpecConfigurator.installSpec200();

        // 1 Вариант (HashMap body + no pojo request + pojo response)

        HashMap<String, Object> requestBody = new HashMap<>();

        String requestName = "Aleksei";
        String requestJob = "QA Engineer";

        requestBody.put("name", requestName);
        requestBody.put("job", requestJob);

        var responseBody = given()
                .body(requestBody)
                .post(Endpoints.Post.postCreateNewUser())
                .then()
                .extract().response().as(PojoResCreateUser.class);

        var responseName = responseBody.getName();

        Assertions.assertThat(responseName).isEqualTo(requestName);

        // 2 Вариант (1 вариант + проверка созданного пользователя)

        HashMap<String, Object> requestBody2 = new HashMap<>();

        String requestName2 = "Aleksei";
        String requestJob2 = "QA Engineer";

        requestBody2.put("name", requestName2);
        requestBody2.put("job", requestJob2);

        var responseBody2 = given()
                .body(requestBody2)
                .post(Endpoints.Post.postCreateNewUser())
                .then()
                .extract().response().as(PojoResCreateUser.class);

        var responseId = responseBody2.getId();

        System.out.println(responseId);
    }

}
