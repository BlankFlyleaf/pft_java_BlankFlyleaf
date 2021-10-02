package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

public class UserModificationTest extends TestBase {

  @Test
  public void testUserModificationTest() {
    app.getUserHelper().selectUser();
    app.getUserHelper().modificateUser();
    app.getUserHelper().fillUserInfo(new UserInfo("Crownslayer", "Reunion", "Palkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658"));
    app.getUserHelper().updateUser();
    app.getNavigationHelper().returnToUserPage();
  }
}
