package services;

import static data.PetData.*;
import static io.restassured.RestAssured.given;

import annotations.Path;
import dto.pet.Category;
import dto.pet.PetDTO;
import dto.pet.Tag;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import java.util.Arrays;

@Path("/pet")
public class PetApi extends AbsBaseApi {

  public PetDTO generateFullPetDTO() {

    Category category = new Category().builder()
        .id(CATEGOTY_ID)
        .name(CATEGOTY_NAME)
        .build();
    Tag tag = new Tag().builder()
        .id(TAG_ID)
        .name(TAG_NAME)
        .build();
    return new PetDTO().builder()
        .name(PET_NAME)
        .id(ID)
        .tags(Arrays.asList(tag))
        .category(category)
        .photoUrls(PHOTO)
        .status(STATUS)
        .build();
  }

  public PetDTO generatePetDTO() {
    return new PetDTO().builder()
        .name(PET_NAME)
        .id(ID)
        .build();
  }

  public ValidatableResponse createPet(PetDTO pet) {
    return validateResponse(given(specification)
        .body(pet)
        .log().all()
        .when()
        .post()
        .then()
    );
  }

  public ValidatableResponse getPet() {
    return given(specification)
        .when()
        .get("/" + ID)
        .then()
        .log().all();
  }

  public ValidatableResponse deletePet() {
    return validateResponseInfo(given(specification)
        .when()
        .delete("/" + ID)
        .then()
        .log().all()
    );
  }

  public ValidatableResponse validateResponse(ValidatableResponse response) {
    return response
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreatePet.json"));
  }

  public ValidatableResponse validateResponseInfo(ValidatableResponse response) {
    return response
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Error.json"));
  }
}
