package backend.method;

import backend.helpers.EndpointsContollers;
import backend.helpers.Service;
import io.restassured.response.Response;

public class MethodUserController {

    public Response getUserByName(String name) {
        return Service.getResponse(EndpointsContollers.UserController.Get.getUserByName(name));
    }
}
