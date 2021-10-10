package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class A_UserCreationTest extends TestBase {

  @Test
  public void testUserCreation() throws Exception {
    Users before = app.user().all();
    File photo = new File("src/test/resources/DioDa.png");
    UserInfo user = new UserInfo()
            .withName("Amiya").withMiddlename("Lalkovna").withLastname("Arknights")
            .withAddress("Voronezh\nSezam street 33")
            .withHome("230539").withMobile("77012347689").withWork("490567")
            .withEmail("lalka@egar.com").withEmail2("palka@egar.com").withEmail3("lulka@egar.com")
            .withGroup("Lalka").withCompany("Egar").withPhoto(photo)
            .withDay("21").withMonth("September").withYear("1658");
    app.user().create(user);

    assertThat(app.user().count(), equalTo(before.size() + 1));
    Users after = app.user().all();
    assertThat(after, equalTo(
            before.with(user.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    assertTrue(photo.exists());
  }

  @Test (enabled = false)
  public void testCurrentDir() throws Exception {
    File currentDir = new File("src/test/resources/DioDa.png");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/DioDa.png");
    System.out.println(photo.exists());
  }
}
