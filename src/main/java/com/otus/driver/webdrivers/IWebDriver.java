package com.otus.driver.webdrivers;

import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public interface IWebDriver {

  WebDriver setDriver();

  default URL getRemoteUrl() {
    try {
      return new URL(System.getProperty("webdriver.remote.url"));
    } catch (MalformedURLException e) {
      return null;
    }
  }
}
