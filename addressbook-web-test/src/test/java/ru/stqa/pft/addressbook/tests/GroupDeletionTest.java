package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToGroupPage();
    app.selectRandomGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }
}

