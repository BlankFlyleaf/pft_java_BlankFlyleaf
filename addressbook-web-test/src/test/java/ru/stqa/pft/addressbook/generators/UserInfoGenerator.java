package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.UserInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UserInfoGenerator {
    public static void main (String args []) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<UserInfo> users = generateUsers(count);
        save(users, file);
    }

    private static void save(List<UserInfo> users, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (UserInfo user : users){
            writer.write(String.format("%s;%s;%s\n", user.getName(), user.getLastname(), user.getMiddlename()));
        }
        writer.close();
    }

    private static List<UserInfo> generateUsers(int count) {
        List<UserInfo> users = new ArrayList<UserInfo>();
        for (int i = 0; i < count; i++) {
            users.add(new UserInfo()
                    .withName(String.format("Amiya %s", i))
                    .withLastname(String.format("Arknights %s", i))
                    .withMiddlename(String.format("Lalkovna %s", i)));
        }
        return users;
    }
}
