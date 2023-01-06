package ui.courses;

import driver.DriverFactory;
import listeners.MouseListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseTest {
  protected EventFiringWebDriver driver;

  @BeforeEach
  public void setUp() {
    driver = new DriverFactory().createInstance();
    driver.register(new MouseListener());
  }

  @AfterEach
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
