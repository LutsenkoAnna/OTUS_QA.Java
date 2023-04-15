package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.Path;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Path("/lessons/")
public class CoursePage extends AbsBasePage<CoursePage> {

  public CoursePage(WebDriver driver) {
    super(driver);
  }

  @Step("Проверяем заголовок на странице курса")
  public CoursePage checkCoursePageTitle(String title) {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
    assertTrue(driver.getTitle().contains(title));
    return this;
  }

  @Step("Проверяем, открыта ли страница курса")
  public CoursePage checkCoursePageOpen() {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
    assertTrue(driver.getCurrentUrl().contains("lessons"));
    return this;
  }
}
