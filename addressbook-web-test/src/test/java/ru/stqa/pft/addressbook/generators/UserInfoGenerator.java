package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
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

    @Parameter(names = "-p", description = "Target Path")
    public String file;

    @Parameter(names = "-f", description = "File Format")
     public String format;

    public static void main(String args[]) throws IOException {
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
        if (format.equals("csv")) {
            saveAsCsv(users, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(users, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(users, new File(file));
        } else {
            System.out.println("Неизвестный формат файла " + format);
        }
    }

    private void saveAsJson(List<UserInfo> users, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(users);
        try (Writer writer = new FileWriter(file)) {
        writer.write(json);
        }
    }

    private void saveAsXML(List<UserInfo> users, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(UserInfo.class);
        String xml = xstream.toXML(users);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<UserInfo> users, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (UserInfo user : users) {
                writer.write(String.format("%s;%s;%s\n",
                        user.getName(), user.getLastname(), user.getMiddlename()));
            }
        }
    }

    private List<UserInfo> generateUsers(int count) {
        List<UserInfo> users = new ArrayList<UserInfo>();
        File photo = new File("src/test/resources/DioDa.png");
        for (int i = 0; i < count; i++) {
            users.add(new UserInfo()
                    .withName(String.format("Amiya %s", i)).withLastname(String.format("Arknights %s", i)).withMiddlename(String.format("Lalkovna %s", i))
                    .withDay("21").withMonth("September").withYear("1658")
                    .withGroup(String.format("Lalka")).withCompany(String.format("Egar")).withPhoto(photo)
                    .withAddress(String.format("Voronezh\nSezam street 33"))
                    .withHome(String.format("230539")).withMobile(String.format("77012347689")).withWork(String.format("490567"))
                    .withEmail(String.format("lalka@egar.com")).withEmail2(String.format("palka@egar.com")).withEmail3(String.format("lulka@egar.com")));
        }
        return users;
    }
}
