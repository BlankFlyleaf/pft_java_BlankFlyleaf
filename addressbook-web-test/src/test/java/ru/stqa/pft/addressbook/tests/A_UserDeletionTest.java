package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class A_UserDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.user().all().size() == 0) {
            app.user().create(new UserInfo()
                    .withName("Amiya").withLastname("Arknights").withGroup("Lalka")
                    .withDay("21").withMonth("September"));
        }
    }

    @Test
    public void testUserDeletion() {
        Users before = app.user().all();
        UserInfo deletedUser = before.iterator().next();
        app.user().delete(deletedUser);

        assertEquals(app.user().count(), before.size() - 1);
        Users after = app.user().all();
        assertThat(after, equalTo(
                before.without(deletedUser)));
    }
}
