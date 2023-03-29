package popups;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

public class FreeLessons {

  public void clickShare() {
    $$(AppiumBy.className("android.widget.TextView"))
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("Share"))
        .click();
  }
}
