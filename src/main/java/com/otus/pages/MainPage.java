package com.otus.pages;

import com.google.inject.Inject;
import com.otus.annotations.Path;
import com.otus.support.GuiceScoped;

@Path("/")
public class MainPage extends AbsBasePage<MainPage> {

  @Inject
  public MainPage(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }
}
