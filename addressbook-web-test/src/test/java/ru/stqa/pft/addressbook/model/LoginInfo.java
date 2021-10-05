package ru.stqa.pft.addressbook.model;

public class LoginInfo {
    private final String username;
    private final String password;

    public LoginInfo(String Username, String Password) {
        username = Username;
        password = Password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
