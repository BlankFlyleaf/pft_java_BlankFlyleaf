package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserInfo;

public class UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    if (!app.getUserHelper().isThereLalka()) {
      app.getNavigationHelper().goToGroupPage();
      app.getGroupHelper().getCreatedGroup(new GroupData("Lalka", "Lalka", "Lalka"));
    }
    app.getUserHelper().getCreatedUser(new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", "Lalka"));
  }
}
