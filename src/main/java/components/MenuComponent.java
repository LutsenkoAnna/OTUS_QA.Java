package components;

import data.CategoryData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CategoryPage;

public class MenuComponent extends AbsBaseComponent<MenuComponent> {

  public MenuComponent(WebDriver driver) {
    super(driver);
  }

  private final String menuItemByTitleSelectorTemplate = "#categories_id [title='%s']";

  public CategoryPage clickCategory(CategoryData categoryData) {
    String selector = String.format(menuItemByTitleSelectorTemplate, categoryData.getName());
    driver.findElement(By.cssSelector(selector)).click();

    return new CategoryPage(driver);
  }

  public MenuComponent menuItemActive(CategoryData categoryData) {
    String selector = String.format("//div[label[contains(text(), %s)]]/div/input", categoryData.getName());
    waiter.waitForCondition(ExpectedConditions.elementToBeSelected(By.xpath(selector)));

    return this;
  }
}
