package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreationCase() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createNewGroup();
    app.getGroupHelper().fillGroupForm(new GroupData("Lalka", "Lalka", "Lalka"));
    app.getGroupHelper().submitGroup();
    app.getNavigationHelper().returnToGroupPage();
  }
}

