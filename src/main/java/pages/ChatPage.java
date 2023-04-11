package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

public class ChatPage extends BasePage<ChatPage> {

  public ChatPage entryLine(String line) {
    $(AppiumBy.className("android.widget.EditText")).sendKeys(line);
    $(AppiumBy.xpath("//android.view.View[@content-desc=\"send\"]")).click();
    return this;
  }

  public boolean isLineExist(String line) {
    return
        $$(AppiumBy.className("android.widget.TextView"))
            .should(CollectionCondition.sizeNotEqual(0))
            .find(Condition.text(line))
            .isDisplayed();
  }
}
