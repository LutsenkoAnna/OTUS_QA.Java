package com.otus.waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaiters {

  private final int implicityWaitSeconds = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitywait", "5000")) / 1000;
  private WebDriver driver;

  public CustomWaiters(WebDriver driver) {
    this.driver = driver;
  }

  public boolean waitForCondition(ExpectedCondition condition) {
    WebDriverWait webDriverWait = new WebDriverWait(driver, implicityWaitSeconds);
    try {
      webDriverWait.until(condition);
      return true;
    } catch (Exception ignored) {
      return false;
    }
  }
}
