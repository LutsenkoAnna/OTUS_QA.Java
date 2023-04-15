package order;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.StoreApi;

public class OrderNegative_Test {

  @Test
  @DisplayName("Get non-existed order")
  @Step("Получение данных по несуществующему заказу (id = 0). Ожидается код 404 и ответ в определенном формате")
  public void getNonExistingOrder() {
    StoreApi storeApi = new StoreApi();
    storeApi.validateResponseError(storeApi.getOrder(0));
  }

  @Test
  @DisplayName("Delete non-existed order")
  @Step("Удаление данных по несуществующему заказу (id = 0). Ожидается код 404 и ответ в определенном формате")
  public void deleteNonExistingOrder() {
    StoreApi storeApi = new StoreApi();
    storeApi.validateResponseError(storeApi.deleteOrder(0));
  }
}
