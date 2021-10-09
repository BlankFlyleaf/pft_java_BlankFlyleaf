package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class A_UserPhoneTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.user().all().size() == 0) {
      app.user().create(new UserInfo()
              .withName("Amiya").withLastname("Arknights").withGroup("Lalka")
              .withDay("21").withMonth("September"));
    }
  }

  @Test
  public void testUserPhones() {
    app.user().returnHome();
    UserInfo user = app.user().all().iterator().next();
    UserInfo UserinfoFromEditForm = app.user().infoFromEditForm(user);

    assertThat(user.getHome(), equalTo(cleaned(UserinfoFromEditForm.getHome())));
    assertThat(user.getMobile(), equalTo(cleaned(UserinfoFromEditForm.getMobile())));
    assertThat(user.getWork(), equalTo(cleaned(UserinfoFromEditForm.getWork())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("-", "").replaceAll("[-()]", "");
  }
}
