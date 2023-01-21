package com.otus.components;

import com.otus.annotations.Component;
import com.google.inject.Inject;
import com.otus.pages.CoursePage;
import com.otus.support.GuiceScoped;
import com.otus.utils.DateUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.LocalDate;
import java.util.*;

@Component(".lessons")
public class CourseComponent extends AbsBaseComponent<CourseComponent> {

  private final String courseNameSelector = ".lessons__new-item-title";
  private final String courseStartDateSelector = ".lessons__new-item-start, .lessons__new-item-time";
  @FindBy(css = ".lessons__new-item")
  private List<WebElement> courseList;
  @Inject
  public CourseComponent(GuiceScoped guiceScoped) {
    super(guiceScoped);
    validate();
  }

  public CoursePage clickCourseByName(String courseName) {
    WebElement course = courseList
        .stream()
        .map(element -> element.findElement(By.cssSelector(courseNameSelector)))
        .filter(element -> element.getText().contains(courseName))
        .findFirst().get();
    course.click();
    return new CoursePage(guiceScoped);
  }

  public CoursePage clickCourseByDate(String date) {
    LocalDate courseDate = new DateUtil().parseDateFromString(date);
    WebElement course = courseList
        .stream()
        .map(element -> element.findElement(By.cssSelector(courseStartDateSelector)))
        .filter(element -> {
          LocalDate currentDate = new DateUtil().parseDateFromString(element.getText());
          return currentDate.isAfter(courseDate);
        })
        .findFirst().get();
    course.click();
    return new CoursePage(guiceScoped);
  }

  private int getCoursePrice(String courseUrl) {
    try {
      Document coursePage = Jsoup.connect(courseUrl).get();
      Elements nobrElement = coursePage.select("div.course-bottom-bar-meta__value nobr");
      if (!nobrElement.isEmpty())
        return Integer.parseInt(
            nobrElement
                .text()
                .replaceAll("[^\\d.]", "")
        );
      else
        return Integer.parseInt(
            coursePage
                .select("div:containsOwn(₽)")
                .last()
                .text()
                .replaceAll("[^\\d.]", "")
        );
    }
    catch (Exception ignored) {
      System.out.println("Can't get price from url " + courseUrl);
    }
    return -1;
  }

  private String getCourseUrl(String href) {
    if (href.startsWith("/"))
      return guiceScoped.driver.getCurrentUrl() + href.substring(1);
    else
      return href;
  }

  public CoursePage clickCourseByPrice(String minmax) {
    Map<WebElement, Integer> courseWithPrice = new HashMap<WebElement, Integer>();
    for (WebElement course : courseList) {
      int coursePrice = getCoursePrice(getCourseUrl(course.getAttribute("href")));
      if (coursePrice != -1)
        courseWithPrice.put(course, coursePrice);
    }
    int price = 0;
    switch (minmax) {
      case "min":
        price = Collections.min(courseWithPrice.values());
        break;
      case "max":
        price = Collections.max(courseWithPrice.values());
        break;
      default:
    }
    int finalPrice = price;
    WebElement course = courseWithPrice
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() == finalPrice)
        .findFirst().get().getKey();
    course.click();;
    return new CoursePage(guiceScoped);
  }
}