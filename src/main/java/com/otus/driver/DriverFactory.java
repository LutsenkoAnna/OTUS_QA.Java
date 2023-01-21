package com.otus.driver;

import com.google.inject.Inject;
import com.otus.driver.webdrivers.ChromeWebDriver;
import com.otus.driver.webdrivers.FirefoxWebDriver;
import com.otus.driver.webdrivers.OperaWebDriver;
import com.otus.exceptions.DriverNotFoundException;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebDriver;
import java.util.Locale;

public class DriverFactory {

  public GuiceScoped guiceScoped;

  @Inject
  public DriverFactory(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
  }

  public WebDriver newDriver() {
    String browser = guiceScoped.browserName.toLowerCase(Locale.ROOT);
    switch (browser) {
      case "chrome":
        return new ChromeWebDriver().setDriver();
      case "opera":
        return new OperaWebDriver().setDriver();
      case "firefox":
        return new FirefoxWebDriver().setDriver();
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
