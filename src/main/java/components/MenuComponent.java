package components;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import data.MenuName;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import pages.ChatPage;
import pages.GrammarPage;

public class MenuComponent extends BaseComponent<MenuComponent> {

  private ElementsCollection menuList = $$(AppiumBy.xpath("//android.widget.HorizontalScrollView/android.view.View/android.view.View"));

  @Step("Получить список меню")
  private ElementsCollection getMenuList() {
    menuList.should(CollectionCondition.sizeNotEqual(0));
    return menuList;
  }

  @Step("Открыть упражнения на Грамматику")
  public GrammarPage openGrammarPage() {
    getMenuList().get(MenuName.GRAMMAR.getID()).click();
    return new GrammarPage();
  }

  @Step("Открыть чат")
  public ChatPage openChatPage() {
    getMenuList().get(MenuName.CHAT.getID()).click();
    return new ChatPage();
  }
}
