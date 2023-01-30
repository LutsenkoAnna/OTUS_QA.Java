package order;

import static data.OrderData.*;

import dto.store.OrderOutDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.StoreApi;


public class OrderPositive_Test {
  public StoreApi storeApi = new StoreApi();

  @BeforeEach
  public void createOrder() {
    storeApi.createOrder(storeApi.generateOrderDTO());
  }

  @AfterEach void deleteOrder() {
    storeApi.deleteOrder();
  }

  @Test
  //Создание заказа с заполнением всех полей. Ожидается код 200 и возврат заполненных полей
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
