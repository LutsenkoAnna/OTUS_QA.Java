package driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements IWebDriver {

  @Override
  public WebDriver setDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk");

    WebDriverManager.chromedriver().setup();

    return new ChromeDriver(options);
  }
}
