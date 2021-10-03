package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserInfo;
import org.openqa.selenium.NotFoundException;


public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void selectUser() {
        click(By.name("selected[]"));
    }

    public void goToUserCreation() {
        click(By.linkText("add new"));
    }

    public void fillUserInfo(UserInfo userInfo, boolean creation) {
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

    public void modificateUser() {
        click(By.xpath("//img[@alt='Edit']"));
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

    public void returnToUserPage() {
        click(By.linkText("home page"));
    }

    public boolean isThereAUser() {
        return isElementPresent(By.name("selected[]"));
    }

    public void getCreatedUser(UserInfo user) {
        goToUserCreation();
        fillUserInfo(user, true);
        submitUser();
        returnToUserPage();
    }

    public void getUpdatedUser(UserInfo user) {
        selectUser();
        modificateUser();
        fillUserInfo(user, false);
        updateUser();
        returnToUserPage();
    }

    public void getDeletedUser() {
        selectUser();
        deleteUser();
        isAlert();
    }
}
