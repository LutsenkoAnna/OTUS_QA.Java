import dto.pet.Category;
import dto.pet.PetDTO;
import dto.pet.PetOutDTO;
import dto.pet.Tag;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.PetApi;
import java.util.Arrays;

public class CreatePet_Test {

  @Test
  //Создание информации о питомце с заполнением всех полей. Ожидается код 200 и возврат заполненных полей
  public void createPet_Test() {
    PetApi petApi = new PetApi();
    Category category = new Category().builder()
        .id(1)
        .name("someCategory")
        .build();
    Tag tag = new Tag().builder()
        .id(2)
        .name("someTag")
        .build();
    PetDTO pet = new PetDTO().builder()
        .name("CatName")
        .id(120)
        .tags(Arrays.asList(tag))
        .category(category)
        .photoUrls(Arrays.asList("photo","photo2"))
        .status("available")
        .build();

    ValidatableResponse response = petApi.createPet(pet)
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreatePet.json"));

    PetOutDTO petOut = response.extract().body().as(PetOutDTO.class);
    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(120, petOut.getId()),
        () -> Assertions.assertEquals("CatName", petOut.getName()),
        () -> Assertions.assertEquals("photo", petOut.getPhotoUrls().get(0)),
        () -> Assertions.assertEquals("available", petOut.getStatus()),
        () -> Assertions.assertEquals("someCategory", petOut.getCategory().getName()),
        () -> Assertions.assertEquals("someTag", petOut.getTags().get(0).getName())
    );
  }

  @Test
  //Создание информации о питомце c заполнением только имени и id. Ожидается код 200 и возврат заполненных полей
  public void createPetWithOnlyName_Test() {
    PetApi petApi = new PetApi();
    PetDTO pet = new PetDTO().builder()
        .name("CatName")
        .id(120)
        .build();

    ValidatableResponse response = petApi.createPet(pet)
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreatePet.json"));

    PetOutDTO petOut = response.extract().body().as(PetOutDTO.class);
    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(120, petOut.getId()),
        () -> Assertions.assertEquals("CatName", petOut.getName())
    );
  }
}
