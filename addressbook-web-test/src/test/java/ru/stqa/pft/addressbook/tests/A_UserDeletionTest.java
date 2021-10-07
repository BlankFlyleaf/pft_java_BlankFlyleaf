package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Set;

public class A_UserDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.user().all().size() == 0) {
      app.user().create(new UserInfo()
              .withName("Amiya").withLastname("Arknights"));
    }
  }

  @Test
  public void testUserDeletion() {
    Set<UserInfo> before = app.user().all();
    UserInfo deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    Set<UserInfo> after = app.user().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedUser);
    Assert.assertEquals(before, after);
  }
}
