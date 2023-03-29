package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage<T> {

  public T open() {
    Selenide.open();
    return (T)this;
  }

}
