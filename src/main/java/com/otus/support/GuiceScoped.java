package com.otus.support;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;

@ScenarioScoped
public class GuiceScoped {

  public WebDriver driver;
  public String browserName;
}
