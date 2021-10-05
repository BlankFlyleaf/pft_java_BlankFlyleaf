package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void createNew() {
        click(By.name("new"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void fill(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initModification() {
        click(By.name("edit"));
    }

    public void deleteChoise() {
        click(By.name("delete"));
    }

    public void submit() {
        click(By.name("submit"));
    }

    public void update() {
        click(By.name("update"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(GroupData group) {
        createNew();
        fill(group);
        submit();
        returnToGroupPage();
    }

    public void modify(int index, GroupData group) {
        select(index);
        initModification();
        fill(group);
        update();
        returnToGroupPage();
    }

    public void delete(int index) {
        select(index);
        deleteChoise();
        returnToGroupPage();
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
            GroupData group = new GroupData()
                    .withName(name).withId(id);
            groups.add(group);
        }
        return groups;
    }
}
