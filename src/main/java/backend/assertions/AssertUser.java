package backend.assertions;

import backend.pojo.petcontroller.findpetbyid.PojoResPet;
import backend.pojo.usercontroller.PojoResUser;
import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertUser {
    private Response response;

    public AssertUser(Response response) {
        this.response = response;
    }

    public void assertUserByName() {
        var user = response.as(PojoResUser.class);

        assertThat(user.getUsername()).isEqualTo("mipkasnow");
    }
}
