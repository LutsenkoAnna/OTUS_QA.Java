package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.*;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

public class StartPage extends BasePage<StartPage> {

  private ElementsCollection nextButton = $$(AppiumBy.className("android.widget.TextView"));

  @Step("Нажали Next")
  public StartPage clickNext() {
    nextButton
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("next"))
        .click();
    return this;
  }

  @Step("Нажали Skip")
  public MainPage clickSkip() {
    $$(AppiumBy.className("android.widget.TextView"))
        .find(Condition.text("Skip >")).click();
    return new MainPage();
  }

  @Step("Убедились, что открылось приложение и есть кнопка Next")
  public boolean isStartPageStarted() {
    return nextButton
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("next"))
        .isDisplayed();
  }
}
