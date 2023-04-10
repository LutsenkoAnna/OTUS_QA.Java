package pet;

import static data.PetData.*;

import dto.pet.PetOutDTO;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.PetApi;


public class PetPositive_Test {

  @Test
  @Step("Создание информации о питомце с заполнением всех полей. Ожидается код 200 и возврат заполненных полей")
  public void createPet() {
    PetApi petApi = new PetApi();
    petApi.createPet(petApi.generateFullPetDTO());

    PetOutDTO petOut = petApi.validateResponse(petApi.getPet())
        .extract()
        .body()
        .as(PetOutDTO.class);

    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(ID, petOut.getId()),
        () -> Assertions.assertEquals(PET_NAME, petOut.getName()),
        () -> Assertions.assertEquals(PHOTO.get(0), petOut.getPhotoUrls().get(0)),
        () -> Assertions.assertEquals(STATUS, petOut.getStatus()),
        () -> Assertions.assertEquals(CATEGOTY_NAME, petOut.getCategory().getName()),
        () -> Assertions.assertEquals(TAG_NAME, petOut.getTags().get(0).getName())
    );

    petApi.deletePet();
  }

  @Test
  @Step("Создание информации о питомце c заполнением только имени и id. Ожидается код 200 и возврат заполненных полей")
  public void createPetWithOnlyName() {
    PetApi petApi = new PetApi();
    petApi.createPet(petApi.generatePetDTO());

    PetOutDTO petOut = petApi.validateResponse(petApi.getPet())
        .extract()
        .body()
        .as(PetOutDTO.class);
    Assertions.assertAll("Check response",
        () -> Assertions.assertEquals(ID, petOut.getId()),
        () -> Assertions.assertEquals(PET_NAME, petOut.getName()),
        () -> Assertions.assertNull(petOut.getPhotoUrls()),
        () -> Assertions.assertNull(petOut.getTags()),
        () -> Assertions.assertNull(petOut.getCategory()),
        () -> Assertions.assertNull(petOut.getStatus())
    );

    petApi.deletePet();
  }
}
