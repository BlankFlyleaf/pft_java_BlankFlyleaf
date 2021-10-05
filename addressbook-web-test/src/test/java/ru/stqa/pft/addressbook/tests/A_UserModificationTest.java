package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Comparator;
import java.util.List;

public class A_UserModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.user().list().size() == 0) {
            app.user().create(new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", "Lalka"));
        }
    }

    @Test
    public void testUserModificationTest() {
        List<UserInfo> before = app.user().list();
        int index = before.size() - 1;
        UserInfo user = new UserInfo("Crownslayer", "Reunion", "Palkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", null, before.get(index).getId());
        app.user().update(index, user);
        List<UserInfo> after = app.user().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(user);
        Comparator<? super UserInfo> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
