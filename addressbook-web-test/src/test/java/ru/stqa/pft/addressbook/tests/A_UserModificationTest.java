package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Comparator;
import java.util.List;

public class A_UserModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.user().list().size() == 0) {
      app.user().create(new UserInfo()
              .withName("Amiya").withLastname("Arknights"));
    }
  }

  @Test
  public void testUserModificationTest() {
    List<UserInfo> before = app.user().list();
    int index = before.size() - 1;
    UserInfo user = new UserInfo()
            .withName("Crownslayer").withMiddlename("Palkovna").withLastname("Reunion")
            .withCompany("Egar").withAddress("Voronezh\nSezam street 33").withHome("23")
            .withMobile("77012347689").withEmail("lalka@egar.com").withGroup(null)
            .withDay("21").withMonth("September").withYear("1658").withId(before.get(index).getId());
    ;
    app.user().update(index, user);
    List<UserInfo> after = app.user().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(user);
    Comparator<? super UserInfo> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
