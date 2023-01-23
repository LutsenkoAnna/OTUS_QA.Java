import static org.hamcrest.Matchers.equalTo;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import services.StoreApi;

public class GetOrder_Test {

  @Test
  //Получение данных по существующему заказу. Проверка только на код 200 и соответствие json, т.к. данные могут варьироваться
  public void getExistingOrder_Test() {
    StoreApi storeApi = new StoreApi();

    ValidatableResponse response = storeApi.getOrder(1)
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateOrder.json"));
  }

  @Test
  //Получение данных по несуществующему заказу (id = 0). Ожидается код 404 и ответ в определенном формате
  public void getNonExistingOrder_Test() {
    StoreApi storeApi = new StoreApi();

    storeApi.getOrder(0)
        .statusCode(404)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Error.json"))
        .body("code", equalTo(1))
        .body("type", equalTo("error"))
        .body("message", equalTo("Order not found"));
  }
}
