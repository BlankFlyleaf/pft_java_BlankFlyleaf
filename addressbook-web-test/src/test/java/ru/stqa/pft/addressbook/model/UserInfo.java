package ru.stqa.pft.addressbook.model;

import java.util.Objects;

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
    private String group;
    private int id;

    public UserInfo(String name, String lastname, String middlename, String company, String address, String home, String mobile, String email, String day, String month, String year, String group) {
        this.name = name;
        this.lastname = lastname;
        this.middlename = middlename;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.group = group;
        this.id = Integer.MAX_VALUE;
    }

    public UserInfo(String name, String lastname, String middlename, String company, String address, String home, String mobile, String email, String day, String month, String year, String group, int id) {
        this.name = name;
        this.lastname = lastname;
        this.middlename = middlename;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.day = day;
        this.month = month;
        this.year = year;
        this.group = group;
        this.id = id;
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

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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