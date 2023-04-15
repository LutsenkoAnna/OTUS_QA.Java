package order;

import static data.OrderData.*;

import dto.store.OrderOutDTO;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import services.StoreApi;


public class OrderPositive_Test {
  public StoreApi storeApi = new StoreApi();

  @BeforeEach
  @Step("Создание тестового заказа")
  public void createOrder() {
    storeApi.createOrder(storeApi.generateOrderDTO());
  }

  @AfterEach
  @Step("Удаление тестового заказа")
  public void deleteOrder() {
    storeApi.deleteOrder();
  }

  @Test
  @DisplayName("Create order")
  @Step("Создание заказа с заполнением всех полей. Ожидается код 200 и возврат заполненных полей")
  public void createFullOrder() {
    OrderOutDTO orderOut = storeApi
        .validateResponse(storeApi.getOrder())
        .extract()
        .body()
        .as(OrderOutDTO.class);

    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(ID, orderOut.getId()),
        () -> Assertions.assertEquals(PET_ID, orderOut.getPetId()),
        () -> Assertions.assertEquals(QUANTITY, orderOut.getQuantity()),
        () -> Assertions.assertEquals(STATUS, orderOut.getStatus()),
        () -> Assertions.assertEquals(COMPLETE, orderOut.getComplete()),
        () -> Assertions.assertEquals(SHIP_DATE, orderOut.getShipDate())
    );
  }
}
