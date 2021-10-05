package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Comparator;
import java.util.List;

public class A_UserCreationTest extends TestBase {

    @Test
    public void testUserCreation() throws Exception {
        List<UserInfo> before = app.user().list();
        UserInfo user = new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", "Lalka");
        app.user().create(user);
        List<UserInfo> after = app.user().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(user);
        Comparator<? super UserInfo> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
