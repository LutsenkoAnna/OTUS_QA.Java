package com.otus.driver.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaWebDriver implements IWebDriver{

  @Override
  public WebDriver setDriver() {
    WebDriverManager.operadriver().setup();
    return new OperaDriver();
  }
}
