package services;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import dto.store.OrderDTO;

public class StoreApi {

  private static final String BASE_URI = "https://petstore.swagger.io/v2";
  private static final String STORE = "/store/order";
  private RequestSpecification specification;

  public StoreApi() {
    specification = given()
        .baseUri(BASE_URI)
        .basePath(STORE)
        .contentType(ContentType.JSON);
  }

  public ValidatableResponse createOrder(OrderDTO order) {
    return given(specification)
        .body(order)
        .when()
        .post()
        .then();
  }

  public ValidatableResponse getOrder(Integer num) {
    return given(specification)
        .when()
        .get("/" + num)
        .then();
  }
}
