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

  public void createNewGroup() {
    click(By.name("new"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void submitGroup() {
    click(By.name("submit"));
  }

  public void updateGroup() {
    click(By.name("update"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public void getCreatedGroup(GroupData group) {
    createNewGroup();
    fillGroupForm(group);
    submitGroup();
    returnToGroupPage();
  }

  public void getUpdatedGroup(GroupData group) {
    initGroupModification();
    fillGroupForm(group);
    updateGroup();
    returnToGroupPage();
  }

  public void getDeletedGroup() {
    deleteSelectedGroup();
    returnToGroupPage();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
      GroupData group = new GroupData(name, null, null, id);
      groups.add(group);
    }
    return groups;
  }
}
