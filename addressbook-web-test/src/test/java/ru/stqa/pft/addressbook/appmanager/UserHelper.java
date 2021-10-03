package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.UserInfo;

public class UserHelper extends HelperBase {
  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitUser() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillUserInfo(UserInfo userInfo) {
    type(By.name("firstname"), userInfo.getName());
    type(By.name("middlename"), userInfo.getMiddlename());
    type(By.name("lastname"), userInfo.getLastname());
    type(By.name("company"), userInfo.getCompany());
    type(By.name("address"), userInfo.getAddress());
    type(By.name("home"), userInfo.getHome());
    type(By.name("mobile"), userInfo.getMobile());
    type(By.name("byear"), userInfo.getYear());
    type(By.name("email"), userInfo.getEmail());
    choose(userInfo.getDay(), By.name("bday"));
    choose(userInfo.getMonth(), By.name("bmonth"));
  }

  public void updateUser() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void selectUser() {
    click(By.name("selected[]"));
  }

  public void modificateUser() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void deleteUser() {
    click(By.xpath("//input[@value='Delete']"));
  }
}
