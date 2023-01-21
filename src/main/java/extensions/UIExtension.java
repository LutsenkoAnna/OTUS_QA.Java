package extensions;

import driver.DriverFactory;
import listeners.MouseListener;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class UIExtension implements BeforeEachCallback, AfterEachCallback, ParameterResolver {

  protected EventFiringWebDriver driver;
  @Override
  public void afterEach(ExtensionContext extensionContext) throws Exception {
    if (driver != null) {
      driver.quit();
    }
  }

  @Override
  public void beforeEach(ExtensionContext extensionContext) throws Exception {
    driver = new DriverFactory().createInstance();
    driver.register(new MouseListener());
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    return parameterContext.getParameter().getType() == WebDriver.class;
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    return driver;
  }
}
