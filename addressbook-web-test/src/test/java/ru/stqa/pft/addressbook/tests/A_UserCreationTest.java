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
            .withCompany("Egar").withAddress("Voronezh\nSezam street 33").withHome("23")
            .withMobile("77012347689").withEmail("lalka@egar.com").withGroup("Lalka")
            .withDay("21").withMonth("September").withYear("1658");
    app.user().create(user);
    Users after = app.user().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.with(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
