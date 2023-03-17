package com.otus.driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OperaWebDriver implements IWebDriver{

  @Override
  public WebDriver setDriver() {
    OperaOptions options = new OperaOptions();
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    options.setCapability(CapabilityType.BROWSER_NAME, "opera");
    options.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("opera.browser.version"));
    options.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVNC")));
    WebDriverManager.operadriver().setup();
    return new RemoteWebDriver(getRemoteUrl(), options);
  }
}
