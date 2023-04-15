package ui.courses;

import components.CourseComponent;
import data.CourseData;
import extensions.UIExtension;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class FindCourse_Test {

  @Test
  @DisplayName("Find course by name")
  @Step("Ищем курс по названию")
  public void findCourseByName_Test(WebDriver driver) {
    new MainPage(driver).open();
    CourseComponent courseComponent = new CourseComponent(driver);
    WebElement elementByName =
        courseComponent
            .findByCourseName(CourseData.MACHINELEARNING.getName());
    courseComponent
        .clickOnCourse(elementByName)
        .checkCoursePageTitle(CourseData.MACHINELEARNING.getName());
  }

  @Test
  @DisplayName("Find latest course")
  @Step("Ищем курс, который стартует позже всех")
  public void findLatestCourse_Test(WebDriver driver) {
    new MainPage(driver).open();
    CourseComponent courseComponent = new CourseComponent(driver);
    WebElement elementLatest =
        courseComponent
            .findCourseByDate("max");
    courseComponent
        .clickOnCourse(elementLatest)
        .checkCoursePageOpen();
  }

  @Test
  @DisplayName("Find earliest course")
  @Step("Ищем курс, который стартует раньше всех")
  public void findEarliestCourse_Test(WebDriver driver) {
    new MainPage(driver).open();
    CourseComponent courseComponent = new CourseComponent(driver);
    WebElement elementEarliest =
        courseComponent
            .findCourseByDate("min");
    courseComponent
        .clickOnCourse(elementEarliest)
        .checkCoursePageOpen();
  }
}
