package demo;

import static com.codeborne.selenide.Selenide.clipboard;

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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

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

  @Test
  @Order(1)
  public void checkChat() {
    ChatPage chatPage = new MenuComponent().openChatPage();
    chatPage.entryLine("Test");
    Assertions.assertTrue(chatPage.isLineExist("Test"));
  }

  @Test
  @Order(2)
  public void getFreeLesson() {
    new MenuComponent().openGrammarPage();
    new BonusComponent().clickFreeLessons();
    new FreeLessons().clickShare();
    new Share().copyLink();

    System.out.println(clipboard().getText());
    Assertions.assertTrue(clipboard().getText().contains("http"));
  }

}
