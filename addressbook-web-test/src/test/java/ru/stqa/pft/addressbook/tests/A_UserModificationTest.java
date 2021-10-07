package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class A_UserModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.user().all().size() == 0) {
      app.user().create(new UserInfo()
              .withName("Amiya").withLastname("Arknights"));
    }
  }

  @Test
  public void testUserModificationTest() {
    Users before = app.user().all();
    UserInfo modifiedUser = before.iterator().next();
    UserInfo user = new UserInfo()
            .withName("Crownslayer").withMiddlename("Palkovna").withLastname("Reunion")
            .withCompany("Egar").withAddress("Voronezh\nSezam street 33").withHome("23")
            .withMobile("77012347689").withEmail("lalka@egar.com").withGroup(null)
            .withDay("21").withMonth("September").withYear("1658").withId(modifiedUser.getId());
    app.user().update(user);
    Users after = app.user().all();

    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(
            before.without(modifiedUser).with(user)));
  }
}
