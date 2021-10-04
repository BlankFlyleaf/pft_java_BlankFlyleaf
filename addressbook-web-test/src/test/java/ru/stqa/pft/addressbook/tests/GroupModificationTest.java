package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().getCreatedGroup(new GroupData("test2", "test2", "test2"));
    }
    app.getGroupHelper().selectRandomGroup();
    app.getGroupHelper().getUpdatedGroup(new GroupData("Lalka", "Lalka", "Lalka"));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
