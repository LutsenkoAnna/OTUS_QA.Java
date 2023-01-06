package pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import annotations.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Path("/lessons/")
public class CoursePage extends AbsBasePage<CoursePage> {

  public CoursePage(WebDriver driver) {
    super(driver);
  }

  public CoursePage checkCoursePageTitle(String title) {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
    assertTrue(driver.getTitle().contains(title));
    return this;
  }

  public CoursePage checkCoursePageOpen() {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
    assertTrue(driver.getCurrentUrl().contains("lessons"));
    return this;
  }
}
