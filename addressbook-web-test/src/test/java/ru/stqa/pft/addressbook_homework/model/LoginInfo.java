package ru.stqa.pft.addressbook_homework.model;

public class LoginInfo {
  private final String username;
  private final String password;

  public LoginInfo(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
