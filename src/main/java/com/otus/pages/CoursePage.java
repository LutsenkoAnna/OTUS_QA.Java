package com.otus.pages;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.inject.Inject;
import com.otus.support.GuiceScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends AbsBasePage<CoursePage> {

  @Inject
  public CoursePage(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  @FindBy(css = "h1")
  private WebElement header;

  public CoursePage pageHeaderShouldBeSameAs(String header) {
    System.out.println("Заголовок курса: " + this.header.getText());
    assertTrue(this.header.getText().equals(header));
    return this;
  }

  public CoursePage pageShouldBeOpen() {
    System.out.println("Заголовок курса: " + this.header.getText());
    assertTrue(this.driver.getCurrentUrl().contains("lessons"));
    return this;
  }
}
