package components;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;


public class BonusComponent extends BaseComponent<BonusComponent> {
  private ElementsCollection bonusName = $$(AppiumBy.className("android.widget.TextView"));

  public void clickFreeLessons() {
    bonusName
        .should(CollectionCondition.sizeNotEqual(0))
        .find(Condition.text("Get free lessons"))
        .click();
  }
}
