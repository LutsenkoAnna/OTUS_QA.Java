package ui.courses;

import components.MenuComponent;
import data.CategoryData;
import driver.DriverFactory;
import extensions.UIExtension;
import listeners.MouseListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.MainPage;

@Disabled("Кейсы были написаны в рамках практики 1")
@ExtendWith(UIExtension.class)
public class ClickCategoryMenu_Test {

  private EventFiringWebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = new DriverFactory().createInstance();
    driver.register(new MouseListener());
  }

  @AfterEach
  public void tearDown() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }

  @Test
  public void clickCategoryMenuItem() throws InterruptedException {
    new MainPage(driver).open();
    MenuComponent menuComponent = new MenuComponent(driver);
    menuComponent.clickCategory(CategoryData.PROGRAMMER);
    menuComponent.menuItemActive(CategoryData.PROGRAMMER);
  }

}
