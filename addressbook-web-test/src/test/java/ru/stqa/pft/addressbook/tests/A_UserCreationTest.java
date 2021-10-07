package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Set;

public class A_UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    Set<UserInfo> before = app.user().all();
    UserInfo user = new UserInfo()
            .withName("Amiya").withMiddlename("Lalkovna").withLastname("Arknights")
            .withCompany("Egar").withAddress("Voronezh\nSezam street 33").withHome("23")
            .withMobile("77012347689").withEmail("lalka@egar.com").withGroup("Lalka")
            .withDay("21").withMonth("September").withYear("1658");
    app.user().create(user);
    Set<UserInfo> after = app.user().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(user);
    Assert.assertEquals(before, after);
  }
}
