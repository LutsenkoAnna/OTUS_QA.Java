package demo;

import com.codeborne.selenide.Selenide;
import components.BonusComponent;
import components.MenuComponent;
import extensions.AppiumExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ChatPage;
import pages.MainPage;
import pages.StartPage;
import popups.Alert;
import popups.FreeLessons;
import popups.Share;

@ExtendWith(AppiumExtension.class)

public class Andy_Test {

  @BeforeEach
  public void skipEntry() {
    new MainPage().open();
    StartPage startPage = new StartPage();
    if (startPage.isStartPageStarted()) {
      startPage
          .clickNext()
          .clickNext()
          .clickSkip();
    }
    Alert alert = new Alert();
    if (alert.isOpen()) {
      alert.close();
    }
  }

  @AfterEach
  public void tearDown() {
    Selenide.closeWebDriver();
  }

  @Test
  public void checkChat() {
    ChatPage chatPage = new MenuComponent().openChatPage();
    chatPage.entryLine("Test");

    Assertions.assertTrue(chatPage.isLineExist("Test"));
  }

  @Test
  public void getFreeLesson() {
    new MenuComponent().openGrammarPage();
    new BonusComponent().clickFreeLessons();
    new FreeLessons().clickShare();

    Assertions.assertTrue(new Share().isShareListExist());
  }

}
