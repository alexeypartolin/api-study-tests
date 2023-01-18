package backend.method;

import backend.helpers.EndpointsContollers;
import backend.helpers.Service;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MethodPetController {

//    public Response getPetById(String id) {
//        var pet = given()
//                .get(EndpointsContollers.PetController.Get.getPetById(id))
//                .then()
//                .extract().response();
//
//        return pet;
//    }

    public Response getPetById(String id) {
        return Service.getResponse(EndpointsContollers.PetController.Get.getPetById(id));
    }
}
