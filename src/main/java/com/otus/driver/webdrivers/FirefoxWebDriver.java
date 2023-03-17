package com.otus.driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxWebDriver implements IWebDriver{

  @Override
  public WebDriver setDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
    options.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("firefox.browser.version"));
    options.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC")));
    WebDriverManager.firefoxdriver().setup();
    return new RemoteWebDriver(getRemoteUrl(), options);
  }
}
