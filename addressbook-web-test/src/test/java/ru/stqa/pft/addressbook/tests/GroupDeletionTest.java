package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectRandomGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getNavigationHelper().returnToGroupPage();
  }
}

