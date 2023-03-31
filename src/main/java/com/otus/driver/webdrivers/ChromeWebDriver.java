package com.otus.driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class ChromeWebDriver implements IWebDriver{

  @Override
  public WebDriver setDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk");
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
    options.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("chrome.browser.version"));
    options.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC")));
    WebDriverManager.chromedriver().setup();

    URL remoteURL = getRemoteUrl();
    if (remoteURL == null) {
      return new ChromeDriver(options);
    } else {
      return new RemoteWebDriver(getRemoteUrl(), options);
    }
  }
}
