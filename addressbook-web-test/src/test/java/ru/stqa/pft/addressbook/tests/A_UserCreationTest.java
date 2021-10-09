package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class A_UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    Users before = app.user().all();
    UserInfo user = new UserInfo()
            .withName("Amiya").withMiddlename("Lalkovna").withLastname("Arknights")
            .withCompany("Egar").withAddress("Voronezh\nSezam street 33").withHome("230539")
            .withMobile("77012347689").withWork("490567").withEmail("lalka@egar.com").withGroup("Lalka")
            .withDay("21").withMonth("September").withYear("1658");
    app.user().create(user);

    assertThat(app.user().count(), equalTo(before.size() + 1));
    Users after = app.user().all();
    assertThat(after, equalTo(
            before.with(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
