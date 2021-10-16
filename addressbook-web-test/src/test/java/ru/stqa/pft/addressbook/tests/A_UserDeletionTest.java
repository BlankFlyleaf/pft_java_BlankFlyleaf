package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class A_UserDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().users().size() == 0) {
            File photo = new File("src/test/resources/pictures/fine.png");
            app.user().create(new UserInfo()
                    .withName("Amiya").withLastname("Arknights")
                    .withDay("21").withMonth("September").withPhoto(photo));
        }
    }

    @Test
    public void testUserDeletion() {
        Users before = app.db().users();
        UserInfo deletedUser = before.iterator().next();
        app.user().delete(deletedUser);

        assertEquals(app.user().count(), before.size() - 1);
        Users after = app.db().users();
        assertThat(after, equalTo(
                before.without(deletedUser)));
        verifyUsersInUi();
    }
}

