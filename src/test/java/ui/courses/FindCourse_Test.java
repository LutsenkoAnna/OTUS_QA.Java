package ui.courses;

import components.CourseComponent;
import data.CourseData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class FindCourse_Test extends BaseTest {

  @Test
  public void findCourseByName_Test() {
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
  public void findLatestCourse_Test() {
    new MainPage(driver).open();
    CourseComponent courseComponent = new CourseComponent(driver);
    WebElement elementLatest =
        courseComponent
            .findLatestCourse();
    courseComponent
        .clickOnCourse(elementLatest)
        .checkCoursePageOpen();
  }

  @Test
  public void findEarliestCourse_Test() {
    new MainPage(driver).open();
    CourseComponent courseComponent = new CourseComponent(driver);
    WebElement elementEarliest =
        courseComponent
            .findEarliestCourse();
    courseComponent
        .clickOnCourse(elementEarliest)
        .checkCoursePageOpen();
  }
}
