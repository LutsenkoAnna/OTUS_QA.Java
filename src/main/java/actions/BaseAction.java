package actions;

import listeners.MouseListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.CustomWaiter;

public abstract class BaseAction {

  protected WebDriver driver;
  protected CustomWaiter waiter;

  public BaseAction(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    this.waiter = new CustomWaiter(driver);
  }

  public static void clickElementAction(WebElement element, WebDriver driver) {
    MouseListener mouseListener = new MouseListener();
    mouseListener.scrollIntoView(element, driver);
    mouseListener.beforeClickOn(element, driver);
    new Actions(driver)
        .moveToElement(element)
        .click()
        .perform();
  }
}
