package driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver implements IWebDriver {
  @Override
  public WebDriver setDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }
}
