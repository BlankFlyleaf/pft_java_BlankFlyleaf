package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().getCreatedGroup(new GroupData("test2", "test2", "test2"));
    }
    app.getGroupHelper().selectRandomGroup();
    app.getGroupHelper().getUpdatedGroup(new GroupData("Lalka", "Lalka", "Lalka"));
  }
}
