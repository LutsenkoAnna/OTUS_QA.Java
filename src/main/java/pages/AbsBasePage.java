package pages;

import annotations.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CustomWaiter;

public abstract class AbsBasePage<T> {

  protected WebDriver driver;
  protected CustomWaiter waiter;
  private String baseUrl = System.getProperty("webdriver.base.url", "https://otus.ru");

  public AbsBasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    this.waiter = new CustomWaiter(driver);
  }

  private String getPath() {
    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Path.class)) {
      Path path = (Path) clazz.getAnnotation(Path.class);
      return path.value();
    }
    return null;
  }

  public T open() {
    driver.get(baseUrl + getPath());
    return (T) this;
  }
}
