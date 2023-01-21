package ui.courses;

import components.CourseComponent;
import data.CourseData;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class FindCourse_Test {

  @Test
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
