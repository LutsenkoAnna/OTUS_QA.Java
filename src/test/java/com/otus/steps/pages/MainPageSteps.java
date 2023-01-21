package com.otus.steps.pages;

import com.google.inject.Inject;
import com.otus.pages.MainPage;
import io.cucumber.java.ru.И;

public class MainPageSteps {

  @Inject
  private MainPage mainPage;

  @И("Открыта главная страница {string}")
  public void openMainPage(String url){
    mainPage.open(url);
  }
}
