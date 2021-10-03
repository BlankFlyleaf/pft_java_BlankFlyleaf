package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

public class UserModificationTest extends TestBase {

  @Test
  public void testUserModificationTest() {
    if (!app.getUserHelper().isThereAUser()) {
      app.getUserHelper().getCreatedUser(new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", "Lalka"));
    }
    app.getUserHelper().getUpdatedUser(new UserInfo("Crownslayer", "Reunion", "Palkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", null));
  }
}
