package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserInfo {
  private String name;
  private String middlename;
  private String lastname;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String email;
  private String day;
  private String month;
  private String year;
  private String group;
  private int id;

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

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  public UserInfo withId(int id) {
    this.id = id;
    return this;
  }

  public UserInfo withName(String name) {
    this.name = name;
    return this;
  }

  public UserInfo withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public UserInfo withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public UserInfo withCompany(String company) {
    this.company = company;
    return this;
  }

  public UserInfo withAddress(String address) {
    this.address = address;
    return this;
  }

  public UserInfo withHome(String home) {
    this.home = home;
    return this;
  }

  public UserInfo withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public UserInfo withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserInfo withDay(String day) {
    this.day = day;
    return this;
  }

  public UserInfo withMonth(String month) {
    this.month = month;
    return this;
  }

  public UserInfo withYear(String year) {
    this.year = year;
    return this;
  }

  public UserInfo withGroup(String group) {
    this.group = group;
    return this;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
            "name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserInfo userInfo = (UserInfo) o;
    return Objects.equals(name, userInfo.name) && Objects.equals(lastname, userInfo.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastname);
  }


}