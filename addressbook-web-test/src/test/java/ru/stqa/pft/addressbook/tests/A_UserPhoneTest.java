package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class A_UserPhoneTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.user().all().size() == 0) {
            app.user().create(new UserInfo()
                    .withName("Amiya").withLastname("Arknights")
                    .withDay("21").withMonth("September")
                    .withHome("230539").withMobile("77012347689").withWork("490567"));
        }
    }

    @Test
    public void testUserPhones() {
        app.user().returnHome();
        UserInfo user = app.user().all().iterator().next();
        UserInfo UserinfoFromEditForm = app.user().infoFromEditForm(user);

        assertThat(user.getAllPhones(), equalTo(mergePhones(UserinfoFromEditForm)));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("-", "").replaceAll("[-()]", "");
    }

    private String mergePhones(UserInfo user) {
        return Arrays.asList(user.getHome(), user.getMobile(), user.getWork())
                .stream().filter((s) -> (!s.equals(""))).map(A_UserPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }
}
