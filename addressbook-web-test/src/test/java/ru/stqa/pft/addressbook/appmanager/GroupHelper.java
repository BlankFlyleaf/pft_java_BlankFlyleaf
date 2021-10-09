package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void createNew() {
    click(By.name("new"));
  }

  public void selectById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void create(GroupData group) {
    createNew();
    fill(group);
    submit();
    groupCashe = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectById(group.getId());
    initModification();
    fill(group);
    update();
    groupCashe = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectById(group.getId());
    deleteChoise();
    groupCashe = null;
    returnToGroupPage();
  }

  private Groups groupCashe = null;

  public Groups all() {
    if (groupCashe != null) {
      return new Groups(groupCashe);
    }
    groupCashe = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
      groupCashe.add(new GroupData().withName(name).withId(id));
    }
    return new Groups(groupCashe);
  }
}
