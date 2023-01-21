package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.support.GuiceScoped;
import com.otus.waiters.CustomWaiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbsBasePage<T> {
  protected WebDriver driver;
  protected CustomWaiters customWaiters;
  protected  GuiceScoped guiceScoped;

  @Inject
  public AbsBasePage(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    this.driver = guiceScoped.driver;
    this.customWaiters = new CustomWaiters(guiceScoped.driver);
    PageFactory.initElements(guiceScoped.driver, this);
  }

  private String getPath() {
    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Path.class)) {
      Path path = (Path) clazz.getAnnotation(Path.class);
      return path.value();
    }
    return null;
  }

  public T open(String url) {
    driver.get(url + getPath());
    return (T) this;
  }
}
