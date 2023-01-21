package com.otus.steps.common;

import com.google.inject.Inject;
import com.otus.driver.DriverFactory;
import com.otus.support.GuiceScoped;
import io.cucumber.java.ru.Пусть;

public class CommonSteps {

  @Inject
  private GuiceScoped guiceScoped;
  @Inject
  private DriverFactory driverFactory;

  @Пусть("Открыт браузер {string}")
  public void openBrowser(String browserName) {
    guiceScoped.browserName = browserName;
    guiceScoped.driver = driverFactory.newDriver();
  }
}
