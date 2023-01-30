package services;

import static data.OrderData.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import annotations.Path;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import dto.store.OrderDTO;

@Path("/store/order")
public class StoreApi extends AbsBaseApi {

  public OrderDTO generateOrderDTO() {
    return new OrderDTO().builder()
        .id(ID)
        .petId(PET_ID)
        .quantity(QUANTITY)
        .shipDate(SHIP_DATE)
        .status(STATUS)
        .complete(COMPLETE)
        .build();
  }

  public ValidatableResponse createOrder(OrderDTO order) {
    return validateResponse(given(specification)
        .body(order)
        .log().all()
        .when()
        .post()
        .then()
    );
  }

  public ValidatableResponse getOrder() {
    return given(specification)
        .when()
        .get("/" + ID)
        .then()
        .log().all();
  }

  public ValidatableResponse getOrder(int num) {
    return given(specification)
        .when()
        .get("/" + num)
        .then()
        .log().all();
  }

  public ValidatableResponse deleteOrder() {
    return validateResponseInfo(given(specification)
        .when()
        .delete("/" + ID)
        .then()
        .log().all()
    );
  }

  public ValidatableResponse deleteOrder(int num) {
    return given(specification)
        .when()
        .delete("/" + num)
        .then()
        .log().all();
  }
  public ValidatableResponse validateResponse(ValidatableResponse response) {
    return response
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateOrder.json"));
  }

  public ValidatableResponse validateResponseInfo(ValidatableResponse response) {
    return response
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Error.json"));
  }

  public ValidatableResponse validateResponseError(ValidatableResponse response) {
    return response
        .statusCode(404)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Error.json"))
        .body("message", equalToIgnoringCase("Order not found"));
  }

}
