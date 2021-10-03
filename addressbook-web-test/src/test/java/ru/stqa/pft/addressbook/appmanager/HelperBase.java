package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void type(By locator, String text) {
    wd.findElement(locator).click();
    if (text != null) {
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }
  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void choose(String day, By locator) {
    new Select(wd.findElement(locator)).selectByVisibleText(day);
  }
}
