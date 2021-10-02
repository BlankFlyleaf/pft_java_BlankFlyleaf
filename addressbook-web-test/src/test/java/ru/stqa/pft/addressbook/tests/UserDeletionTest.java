package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class UserDeletionTest extends TestBase {

  @Test

  public void testUserDeletion() {
    app.getUserHelper().selectUser();
    app.getUserHelper().deleteUser();
    app.getSessionHelper().isAlert();
  }
}
