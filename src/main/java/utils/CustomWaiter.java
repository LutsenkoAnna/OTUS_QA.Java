package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaiter {
  private final int implicityWaitSeconds = Integer.parseInt(System.getProperty("webdriver.timeouts.implicitywait", "5000")) / 1000;
  private WebDriver driver;

  public CustomWaiter(WebDriver driver) {
    this.driver = driver;
  }

  public boolean waitForCondition(ExpectedCondition expectedCondition) {
    WebDriverWait webDriverWait = new WebDriverWait(driver, implicityWaitSeconds);
    try {
      webDriverWait.until(expectedCondition);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}
