package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("group page"));
  }

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.tagName("new"))) {
      return;
    }
      click(By.linkText("groups"));
  }

  public void returnToUserPage() {
    click(By.linkText("home page"));
  }

  public void goToUserCreation() {
    click(By.linkText("add new"));
  }
}
