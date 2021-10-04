package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.util.List;

public class UserDeletionTest extends TestBase {

    @Test
    public void testUserDeletion() {
        List<UserInfo> before = app.getUserHelper().getUserList();
        if (!app.getUserHelper().isThereAUser()) {
            app.getUserHelper().getCreatedUser(new UserInfo("Amiya", "Arknights", "Lalkovna", "Egar", "Voronezh\nSezam street 33", "23", "77012347689", "lalka@egar.com", "21", "September", "1658", "Lalka"));
        }
        app.getUserHelper().selectUser(before.size() - 1);
        app.getUserHelper().getDeletedUser();
        List<UserInfo> after = app.getUserHelper().getUserList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
