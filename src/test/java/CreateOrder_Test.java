import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.StoreApi;
import dto.store.OrderDTO;
import dto.store.OrderOutDTO;

public class CreateOrder_Test {

  @Test
  //Создание заказа с заполнением всех полей. Ожидается код 200 и возврат заполненных полей
  public void createFullOrder_Test() {
    StoreApi storeApi = new StoreApi();
    OrderDTO order = new OrderDTO().builder()
        .id(100)
        .petId(10)
        .quantity(2)
        .shipDate("2023-02-01T10:10:14.232Z")
        .status("placed")
        .complete(true)
        .build();

    ValidatableResponse response = storeApi.createOrder(order)
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateOrder.json"));

    OrderOutDTO orderOut = response.extract().body().as(OrderOutDTO.class);
    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(100, orderOut.getId()),
        () -> Assertions.assertEquals(10, orderOut.getPetId()),
        () -> Assertions.assertEquals(2, orderOut.getQuantity()),
        () -> Assertions.assertEquals("placed", orderOut.getStatus()),
        () -> Assertions.assertEquals(true, orderOut.getComplete()),
        () -> Assertions.assertEquals("2023-02-01T10:10:14.232+0000", orderOut.getShipDate())
    );
  }

  @Test
  //Создание заказа с пустыми полями. Ожидается код 200
  public void createEmptyOrder_Test() {
    StoreApi storeApi = new StoreApi();
    OrderDTO order = new OrderDTO().builder().build();

    ValidatableResponse response = storeApi.createOrder(order)
        .statusCode(200)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/CreateOrder.json"));
  }

}
