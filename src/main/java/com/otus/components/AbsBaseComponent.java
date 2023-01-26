package com.otus.components;

import com.otus.annotations.Component;
import com.otus.listeners.MouseListener;
import com.otus.support.GuiceScoped;
import com.otus.waiters.CustomWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class AbsBaseComponent<T> {
  protected WebDriver driver;
  protected CustomWaiters waiter;
  protected GuiceScoped guiceScoped;
  protected MouseListener mouseListener;

  public AbsBaseComponent(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    this.driver = guiceScoped.driver;
    this.waiter = new CustomWaiters(guiceScoped.driver);
    PageFactory.initElements(guiceScoped.driver, this);
    this.mouseListener = new MouseListener();
  }

  private By getComponent() {
    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Component.class)) {
      Component component = (Component) clazz.getAnnotation(Component.class);
      String value = component.value();

      if (value.startsWith("/")) {
        return By.xpath(value);
      }
      return By.cssSelector(value);
    }
    return null;
  }

  public void validate() {
    waiter.waitForCondition(ExpectedConditions.presenceOfElementLocated(getComponent()));
  }

}
