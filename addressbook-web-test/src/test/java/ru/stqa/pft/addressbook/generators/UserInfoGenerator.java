package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.UserInfo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UserInfoGenerator {

    @Parameter(names = "-c", description = "User counts")
    public int count;

    @Parameter(names = "-f", description = "Target File")
    public String file;

    public static void main (String args []) throws IOException {
        UserInfoGenerator generator = new UserInfoGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<UserInfo> users = generateUsers(count);
        save(users, new File(file));
    }

    private void save(List<UserInfo> users, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (UserInfo user : users){
            writer.write(String.format("%s;%s;%s\n", user.getName(), user.getLastname(), user.getMiddlename()));
        }
        writer.close();
    }

    private List<UserInfo> generateUsers(int count) {
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
