package popups;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

public class Share {

  public void sendMessage() {
    $$(AppiumBy.className("android.widget.TextView"))
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("Messaging"))
        .click();
  }

  public boolean isShareListExist() {
    return $$(AppiumBy.className("android.widget.TextView"))
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("Messaging"))
        .isDisplayed();
  }
}
