package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class A_UserMailTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.user().all().size() == 0) {
            app.user().create(new UserInfo()
                    .withName("Amiya").withLastname("Arknights")
                    .withGroup("Lalka").withDay("21").withMonth("September")
                    .withAddress("Voronezh\nSezam street 33")
                    .withEmail("lalka@egar.com").withEmail2("palka@egar.com").withEmail3("lulka@egar.com"));
        }
    }

    @Test
    public void testUserMails() {
        app.user().returnHome();
        UserInfo user = app.user().all().iterator().next();
        UserInfo UserinfoFromEditForm = app.user().infoFromEditForm(user);

        assertThat(user.getAllMails(), equalTo(mergeMails(UserinfoFromEditForm)));
        assertThat(user.getAddress(), equalTo(checkAddress(UserinfoFromEditForm)));
        app.user().returnHome();
    }

    private String mergeMails(UserInfo user) {
        return Arrays.asList(user.getEmail1(), user.getEmail2(), user.getEmail3())
                .stream().filter((s) -> (!s.equals("")))
                .collect(Collectors.joining("\n"));
    }

    private String checkAddress(UserInfo user) {
        return Arrays.asList(user.getAddress())
                .stream().filter((s) -> (!s.equals("")))
                .collect(Collectors.joining("\n"));
    }
}