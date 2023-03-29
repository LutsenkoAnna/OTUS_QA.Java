package extensions;

import com.codeborne.selenide.Configuration;
import com.sun.javafx.runtime.SystemProperties;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import providers.SelenideWebDriver;

public class AppiumExtension implements BeforeAllCallback {

  @Override
  public void beforeAll(ExtensionContext extensionContext) throws Exception {
    Configuration.browserSize = null;
    Configuration.browser = SelenideWebDriver.class.getName();
    Configuration.timeout = Long.parseLong(System.getProperty("android.timeout"));
  }
}