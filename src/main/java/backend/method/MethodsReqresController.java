package backend.method;

import backend.helpers.Endpoints;
import backend.helpers.Service;
import io.restassured.response.Response;

public class MethodsReqresController {
    //    public Response getPetById(String id) {
    //        var pet = given()
    //                .get(EndpointsContollers.PetController.Get.getPetById(id))
    //                .then()
    //                .extract().response();
    //
    //        return pet;
    //    }

    public Response methodGetListUsersFromPage(int numOfPage) {
        return Service.getResponseCustomMethod(Endpoints.Get.getListUsersFromPage(numOfPage));
    }
}
