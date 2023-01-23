package services;

import static io.restassured.RestAssured.given;

import dto.pet.PetDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class PetApi {

  private static final String BASE_URI = "https://petstore.swagger.io/v2";
  private static final String STORE = "/pet";
  private RequestSpecification specification;

  public PetApi() {
    specification = given()
        .baseUri(BASE_URI)
        .basePath(STORE)
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse createPet(PetDTO pet) {
    return given(specification)
        .body(pet)
        .when()
        .post()
        .then();
  }
}
