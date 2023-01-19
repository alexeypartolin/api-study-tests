package backend.assertions;

import backend.pojo.reqrespojocontrollers.getlistusersfrompage.PojoResUsers;
import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertUsers {
    private Response response;

    public AssertUsers(Response response) {
        this.response = response;
    }

    public void assertUsersOnPage() {
        var listOfUsers = response.as(PojoResUsers.class);

//        assertThat(listOfUsers.getPage()).isEqualTo() // проверить что page в json isEqualTo значению в запросе
        assertThat(listOfUsers.getData().get(0).getId()).isEqualTo(7);
    }
}
