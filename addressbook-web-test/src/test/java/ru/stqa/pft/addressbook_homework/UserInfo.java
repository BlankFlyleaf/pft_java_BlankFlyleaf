package ru.stqa.pft.addressbook_homework;

public class UserInfo {
  private final String name;
  private final String middlename;
  private final String lastname;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String email;
  private final String day;
  private final String month;
  private final String year;

  public UserInfo(String name, String middlename, String lastname, String company, String address, String home, String mobile, String email, String day, String month, String year) {
    this.name = name;
    this.middlename = middlename;
    this.lastname = lastname;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.email = email;
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getDay() {
    return day;
  }

  public String getMonth() {
    return month;
  }

  public String getYear() {
    return year;
  }
}
