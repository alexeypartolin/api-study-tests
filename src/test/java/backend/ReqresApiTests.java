package backend;

import backend.assertions.AssertUsers;
import backend.helpers.SpecConfigurator;
import backend.method.MethodsReqresController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReqresApiTests {
    private final MethodsReqresController methodsReqresController = new MethodsReqresController();
    @Test
    @DisplayName("Получение списка пользователей на странице и проверка id первого пользователя")
    public void getListOfUsersByPage() {
        SpecConfigurator.installSpec200();

        var listOfUsers = methodsReqresController.methodGetListUsersFromPage(2);

        new AssertUsers(listOfUsers).assertUsersOnPage();
    }

}
