package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.Comparator;
import java.util.List;

public class A_UserModificationTest extends TestBase {

    @Test
    public void testUserModificationTest() {
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().goToUserCreation();
            app.getUserHelper().getCreatedUser(new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", "Lalka"));
        }
        List<UserInfo> before = app.getUserHelper().getUserList();
        app.getUserHelper().selectUser((before.size() - 1));
        app.getUserHelper().modificateUser((before.size() - 1));
        UserInfo user = new UserInfo("Crownslayer", "Reunion", "Palkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", null, before.get(before.size() - 1).getId());
        app.getUserHelper().getUpdatedUser(user);
        List<UserInfo> after = app.getUserHelper().getUserList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(user);
        Comparator<? super UserInfo> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
