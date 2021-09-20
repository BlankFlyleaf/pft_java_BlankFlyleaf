package ru.stqa.pft.addressbook.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserCreationTest {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
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

  @Test
  public void testUserCreation() throws Exception {
    goToUserCreation();
    fillUserInfo(new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658"));
    submitUser();
    returnToUserPage();
  }

  private void returnToUserPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitUser() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillUserInfo(UserInfo userInfo) {
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

  private void goToUserCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    logOut();
    wd.quit();
  }

  private void logOut() {
    wd.findElement(By.linkText("Logout")).click();
  }
}
