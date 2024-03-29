package components;

import actions.BaseAction;
import annotations.Component;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CoursePage;
import utils.DateUtil;
import java.time.LocalDate;
import java.util.List;

@Component(".lessons")
public class CourseComponent extends AbsBaseComponent<CourseComponent> {
  private final String courseNameSelector = ".lessons__new-item-title";
  private final String courseStartDateSelector = ".lessons__new-item-start, .lessons__new-item-time";

  @FindBy(css = ".lessons__new-item")
  private List<WebElement> courseList;

  public CourseComponent(WebDriver driver) {
    super(driver);
    validate();
  }

  public WebElement findByCourseName(String name) {
    return courseList
        .stream()
        .map(element -> element.findElement(By.cssSelector(courseNameSelector)))
        .filter(element -> element.getText().contains(name))
        .findFirst().get();
  }

  @Step("Проверяем даты курсов")
  public WebElement findCourseByDate(String minmax) {
    return courseList
        .stream()
        .map(el -> el.findElement(By.cssSelector(courseStartDateSelector)))
        .reduce((el1, el2) -> {
          LocalDate date1 = new DateUtil().parseDateFromString(el1.getText());
          LocalDate date2 = new DateUtil().parseDateFromString(el2.getText());
          switch (minmax) {
            case "min":
              return date1.isBefore(date2) ? el1 : el2;
            case "max":
              return date1.isAfter(date2) ? el1 : el2;
            default:
              return null;
          }
        }).get();
  }

  @Step("Кликаем на курс")
  public CoursePage clickOnCourse(WebElement element) {
    BaseAction.clickElementAction(element, driver);
    return new CoursePage(driver);
  }
}
