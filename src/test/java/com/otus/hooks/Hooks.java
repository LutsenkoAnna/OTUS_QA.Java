package com.otus.hooks;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import io.cucumber.java.After;

public class Hooks {

  @Inject
  private GuiceScoped guiceScoped;

  @After
  public void tearDown() {
    if (guiceScoped.driver != null) {
      guiceScoped.driver.quit();
    }
  }


}
