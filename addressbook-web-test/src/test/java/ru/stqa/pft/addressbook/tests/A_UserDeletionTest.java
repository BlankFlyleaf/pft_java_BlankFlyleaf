package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.List;

public class A_UserDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.user().list().size() == 0) {
      app.user().create(new UserInfo()
              .withName("Amiya").withLastname("Arknights"));
    }
  }

  @Test
  public void testUserDeletion() {
    List<UserInfo> before = app.user().list();
    int index = before.size() - 1;
    app.user().delete(index);
    List<UserInfo> after = app.user().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
