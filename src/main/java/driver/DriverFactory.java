package driver;

import driver.webdrivers.ChromeWebDriver;
import driver.webdrivers.FirefoxWebDriver;
import driver.webdrivers.OperaWebDriver;
import exceptions.DriverNotFoundException;
import io.qameta.allure.Step;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.Locale;

public class DriverFactory {

  private final String browser = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);

  @Step("Создаем драйвер")
  public EventFiringWebDriver createInstance() {
    switch (browser) {
      case "chrome": {
        return new EventFiringWebDriver(new ChromeWebDriver().setDriver());
      }
      case "opera": {
        return new EventFiringWebDriver(new OperaWebDriver().setDriver());
      }
      case "firefox": {
        return new EventFiringWebDriver(new FirefoxWebDriver().setDriver());
      }
      default: {
        try {
          throw new DriverNotFoundException(browser);
        } catch (DriverNotFoundException e) {
          e.printStackTrace();
        }
      }

    }
    return null;
  }
}
