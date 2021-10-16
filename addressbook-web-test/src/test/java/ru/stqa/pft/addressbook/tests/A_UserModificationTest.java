package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;
import ru.stqa.pft.addressbook.model.Users;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class A_UserModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.user().all().size() == 0) {
            File photo = new File("src/test/resources/pictures/fine.png");
            app.user().create(new UserInfo()
                    .withName("Amiya").withLastname("Arknights")
                    .withDay("21").withMonth("September").withPhoto(photo));
        }
    }

    @Test
    public void testUserModificationTest() {
        Users before = app.db().users();
        File photo = new File("src/test/resources/pictures/fine.png");
        UserInfo modifiedUser = before.iterator().next();
        UserInfo user = new UserInfo()
                .withName("Crownslayer").withMiddlename("Palkovna").withLastname("Reunion")
                .withCompany("Egar").withAddress("Voronezh\nSezam street 33")
                .withHome("240539").withMobile("77102347689").withWork("699669")
                .withEmail("Reunion@egar.com").withEmail2("Did@egar.com").withEmail3("NothingWrong@egar.com").withPhoto(photo)
                .withDay("21").withMonth("September").withYear("1658").withId(modifiedUser.getId());
        app.user().update(user);

        assertEquals(app.user().count(), before.size());
        Users after = app.db().users();
        assertThat(after, equalTo(
                before.without(modifiedUser).with(user)));
        verifyUsersInUi();
    }
}
