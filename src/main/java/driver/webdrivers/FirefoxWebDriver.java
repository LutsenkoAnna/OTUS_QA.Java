package driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class FirefoxWebDriver implements IWebDriver {
  @Override
  public WebDriver setDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
    options.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("firefox.browser.version"));
    options.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC")));
    WebDriverManager.firefoxdriver().setup();

    URL remoteURL = getRemoteUrl();
    if (remoteURL == null) {
      return new FirefoxDriver(options);
    } else {
      return new RemoteWebDriver(getRemoteUrl(), options);
    }
  }
}
