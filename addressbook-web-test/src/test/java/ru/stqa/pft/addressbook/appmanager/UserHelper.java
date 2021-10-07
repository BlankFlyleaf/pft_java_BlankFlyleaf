package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import java.util.List;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void modificateById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
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

    public void create(UserInfo user) {
        addNew();
        fillInfo(user, true);
        submitUser();
        userCashe = null;
        returnHomePage();
    }

    public void update(UserInfo user) {
        modificateById(user.getId());
        fillInfo(user, false);
        updateUser();
        userCashe = null;
        returnHomePage();
    }

    public void delete(UserInfo user) {
        selectById(user.getId());
        deleteUser();
        isAlert();
        userCashe = null;
        returnHome();
    }

    private Users userCashe = null;

    public Users all() {
        if (userCashe != null) {
            return new Users(userCashe);
        }

        userCashe = new Users();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String name = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            userCashe.add(new UserInfo().withName(name).withLastname(lastname).withId(id));
        }
        return new Users(userCashe);
    }
}
