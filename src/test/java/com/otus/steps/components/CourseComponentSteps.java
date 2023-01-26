package com.otus.steps.components;

import com.google.inject.Inject;
import com.otus.components.CourseComponent;
import io.cucumber.java.ru.Если;

public class CourseComponentSteps {

  @Inject
  private CourseComponent courseComponent;

  @Если("Кликнуть на курс {string}")
  public void clickCourseTitle(String courseName) {
    courseComponent.clickCourseByName(courseName);
  }

  @Если("Кликнуть на курс с датой больше {string}")
  public void clickCourseDate(String courseDate) {
    courseComponent.clickCourseByDate(courseDate);
  }

  @Если("Кликнуть на самый дешевый курс")
  public void clickCheapestCourse() {
    courseComponent.clickCourseByPrice(true);
  }

  @Если("Кликнуть на самый дорогой курс")
  public void clickExpensiveCourse() {
    courseComponent.clickCourseByPrice(false);
  }
}
