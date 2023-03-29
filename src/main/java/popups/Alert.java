package popups;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
public class Alert {

  public void close() {
    $(AppiumBy.id("android:id/button1"))
        .click();
  }

  public boolean isOpen() {
    return $(AppiumBy.id("android:id/alertTitle"))
        .should(Condition.visible)
        .isDisplayed();
  }
}
