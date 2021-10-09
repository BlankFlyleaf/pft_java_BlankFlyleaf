package ru.stqa.pft.addressbook.model;

public class LoginInfo {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public LoginInfo withUsername(String username) {
    this.username = username;
    return this;
  }

  public LoginInfo withPassword(String password) {
    this.password = password;
    return this;
  }
}
