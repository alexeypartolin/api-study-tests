package backend;

import backend.assertions.AssertPet;
import backend.assertions.AssertUser;
import backend.helpers.EndpointsContollers;
import backend.helpers.SpecConfigurator;
import backend.method.MethodPetController;
import backend.method.MethodUserController;
import backend.pojo.petcontroller.findpetbyid.PojoResPet;
import backend.pojo.usercontroller.PojoResOrderId;
import backend.pojo.usercontroller.PojoResUserWithoutLombok;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PetshopTests {
//    @BeforeAll
//    public static void setUp() {
//        SpecConfigurator.installSpecification200();
//    }

    private final MethodPetController petController = new MethodPetController();

    @Test
    public void getUserTest() {
        given()
                .log().uri()
                .get("https://petstore.swagger.io/v2/user/mipkasnow")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getUserTest2() {
        given()
                .get("/user/mipkasnow")
                .then();
    }

    @Test
    public void getUserTest3() {
        given()
                .get(EndpointsContollers.UserController.Get.getUserByName("mipkasnow"))
                .then();
    }

    @Test
    public void getUserTest4() {
        var user = given()
                .get(EndpointsContollers.UserController.Get.getUserByName("alexpartolin"))
                .then()
                .extract().body().as(PojoResUserWithoutLombok.class);

           Assertions.assertThat(user.getEmail()).isEqualTo("test@mail.ru");
    }

    @Test
    @DisplayName("Получение заказа по его id -> сравнение результата")
    public void getOrderIdTest() {
        var orderBody = given()
                .get(EndpointsContollers.OrderController.Get.getOrderById(4))
                .then()
                .extract().body().as(PojoResOrderId.class);

        Assertions.assertThat(orderBody.getComplete()).isEqualTo(true);
    }

    @Test
    public void getPetById() {
        var pet = given()
                .get(EndpointsContollers.PetController.Get.getPetById("9347"))
                .then()
                .extract().body().as(PojoResPet.class);
    }

    @Test
    public void getPetById2() {

        var pet = given()
                .get(EndpointsContollers.PetController.Get.getPetById("9347"))
                .then()
                .extract().body().as(PojoResPet.class);

        assertThat(pet.getTags().get(2).getName()).isEqualTo("smart");

    }

    @Test
    public void getPetById3() {

        var pet = given()
                .get(EndpointsContollers.PetController.Get.getPetById("9347"))
                .then()
                .extract().response();

        new AssertPet(pet).assertPetById();

    }

    ///

    @Test
    public void getPetById4() {
        SpecConfigurator.installSpecification200(); // надо вынести в @BeforeALl

        var pet = petController.getPetById("9347");
        new AssertPet(pet).assertPetById();
    }

    @Test
    public void getUserTestBestPractice() {
        SpecConfigurator.installSpecification200();
        MethodUserController userController = new MethodUserController();

        var user = userController.getUserByName("mipkasnow");

        new AssertUser(user).assertUserByName();
    }


}
