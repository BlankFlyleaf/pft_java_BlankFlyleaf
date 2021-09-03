package ru.stqa.pft.addressbook_homework.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook_homework.model.LoginInfo;
import ru.stqa.pft.addressbook_homework.model.UserInfo;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private WebDriver wd;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    logIn(new LoginInfo("admin", "secret"));
  }

  private void logIn(LoginInfo loginInfo) {
    wd.findElement(By.name("user")).sendKeys(loginInfo.getUsername());
    wd.findElement(By.name("pass")).sendKeys(loginInfo.getPassword());
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void returnToUserPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public void submitUser() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillUserInfo(UserInfo userInfo) {
    wd.findElement(By.name("firstname")).sendKeys(userInfo.getName());
    wd.findElement(By.name("middlename")).sendKeys(userInfo.getMiddlename());
    wd.findElement(By.name("lastname")).sendKeys(userInfo.getLastname());
    wd.findElement(By.name("company")).sendKeys(userInfo.getCompany());
    wd.findElement(By.name("address")).sendKeys(userInfo.getAddress());
    wd.findElement(By.name("home")).sendKeys(userInfo.getHome());
    wd.findElement(By.name("mobile")).sendKeys(userInfo.getMobile());
    wd.findElement(By.name("email")).sendKeys(userInfo.getEmail());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(userInfo.getDay());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(userInfo.getMonth());
    wd.findElement(By.name("byear")).sendKeys(userInfo.getYear());
  }

  public void goToUserCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void end() {
    logOut();
    wd.quit();
  }

  private void logOut() {
    wd.findElement(By.linkText("Logout")).click();
  }
}
