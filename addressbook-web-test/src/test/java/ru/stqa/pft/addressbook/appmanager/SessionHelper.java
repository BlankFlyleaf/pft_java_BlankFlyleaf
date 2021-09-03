package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.LoginInfo;

public class SessionHelper extends HelperBase {

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void logIn (LoginInfo loginInfo) {
    type(By.name("user"), loginInfo.getUsername());
    type(By.name("pass"), loginInfo.getPassword());
    click(By.xpath("//input[@value='Login']"));
  }

  protected void logOut() {
    click(By.linkText("Logout"));
  }
}
