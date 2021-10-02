package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void returnToUserPage() {
    click(By.linkText("home page"));
  }

  public void goToUserCreation() {
    click(By.linkText("add new"));
  }
}
