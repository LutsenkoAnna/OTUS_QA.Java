package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.*;
import io.appium.java_client.AppiumBy;
import java.time.Duration;

public class StartPage extends BasePage<StartPage> {

  private ElementsCollection nextButton = $$(AppiumBy.className("android.widget.TextView"));

  public StartPage clickNext() {
    nextButton
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("next"))
        .click();
    return this;
  }

  public MainPage clickSkip() {
    $$(AppiumBy.className("android.widget.TextView"))
        .find(Condition.text("Skip >")).click();
    return new MainPage();
  }

  public boolean isStartPageStarted() {
    return nextButton
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("next"))
        .isDisplayed();
  }
}
