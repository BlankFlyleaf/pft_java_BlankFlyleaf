package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {
  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void addNew() {
    click(By.linkText("add new"));
  }

  public void fillInfo(UserInfo userInfo, boolean creation) {
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
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userInfo.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void modificate(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void deleteUser() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void submitUser() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void updateUser() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void returnHomePage() {
    click(By.linkText("home page"));
  }

  public void returnHome() {
    click(By.linkText("home"));
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(UserInfo user) {
    addNew();
    fillInfo(user, true);
    submitUser();
    returnHomePage();
  }

  public void update(int index, UserInfo user) {
    modificate(index);
    fillInfo(user, false);
    updateUser();
    returnHomePage();
  }

  public void delete(int index) {
    select(index);
    deleteUser();
    isAlert();
    returnHome();
  }

  public List<UserInfo> list() {
    List<UserInfo> users = new ArrayList<UserInfo>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      UserInfo user = new UserInfo()
              .withName(name).withLastname(lastname).withId(id);
      users.add(user);
    }
    return users;
  }
}
