package backend.assertions;


import backend.pojo.petcontroller.findpetbyid.PojoResPet;
import io.restassured.response.Response;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertPet {
    private Response response;

    public AssertPet(Response response) {
        this.response = response;
    }

    public void assertPetById() {
        var pet = response.as(PojoResPet.class);

        assertThat(pet.getId()).isEqualTo(9347);
        assertThat(pet.getCategory().getName()).isEqualTo("Dog");
        assertThat(pet.getPhotoUrls().get(3).toString()).contains("4");
        assertThat(pet.getTags().get(0).getId()).isEqualTo(3);
    }
}
