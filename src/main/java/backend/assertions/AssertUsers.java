package backend.assertions;

import backend.pojo.reqrespojocontrollers.getlistusersfrompage.PojoResUsers;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertUsers {
    private Response response;

    public AssertUsers(Response response) {
        this.response = response;
    }

    public void assertUsersOnPage() {
        var listOfUsers123 = response.as(PojoResUsers.class);

//        assertThat(listOfUsers.getPage()).isEqualTo() // проверить что page в json isEqualTo значению в запросе
        assertThat(listOfUsers123.getData().get(0).getId()).isEqualTo(7);
    }

    public void assertUserIdInData() {
        var responseForAssert = response;

        var actualResult4 = response.jsonPath().get("data[5].id");
        var expectedResult4 = 12;

        assertThat(actualResult4).isEqualTo(expectedResult4);
    }
}
