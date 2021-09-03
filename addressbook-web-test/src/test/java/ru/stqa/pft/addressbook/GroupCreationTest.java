package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreationCase() throws Exception {
    goToGroupPage();
    createNewGroup();
    fillGroupForm(new GroupData("test2", "test2", "test2"));
    submitGroup();
    returnToGroupPage();
  }
}

