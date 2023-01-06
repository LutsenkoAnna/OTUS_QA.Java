package components;

import annotations.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CustomWaiter;

public abstract class AbsBaseComponent<T> {

  protected WebDriver driver;
  protected CustomWaiter waiter;

  public AbsBaseComponent(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    this.waiter = new CustomWaiter(driver);
  }

  private By getComponent() {
    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Component.class)) {
      Component component = (Component) clazz.getAnnotation(Component.class);
      String value = component.value();

      if (value.startsWith("/")) {
        return By.xpath(value);
      }
      return By.cssSelector(value);
    }
    return null;
  }

  public void validate() {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(getComponent()));
  }
}
