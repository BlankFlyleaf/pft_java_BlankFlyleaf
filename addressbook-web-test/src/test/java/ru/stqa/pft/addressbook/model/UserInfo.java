package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("users")
@Entity
@Table(name = "addressbook")
public class UserInfo {

    @Expose
    @Column(name = "firstname")
    public String name;

    @Expose
    @Column(name = "middlename")
    public String middlename;

    @Expose
    @Column(name = "lastname")
    public String lastname;

    @Expose
    @Column(name = "company", columnDefinition = "text")
    public String company;

    @Expose
    @Column(name = "address", columnDefinition = "text")
    public String address;

    @Expose
    @Column(name = "home", columnDefinition = "text")
    public String home;

    @Expose
    @Column(name = "mobile", columnDefinition = "text")
    public String mobile;

    @Expose
    @Column(name = "work", columnDefinition = "text")
    public String work;

    @Expose
    @Column(name = "email", columnDefinition = "text")
    public String email1;

    @Expose
    @Column(name = "email2", columnDefinition = "text")
    public String email2;

    @Expose
    @Column(name = "email3", columnDefinition = "text")
    public String email3;

    @Expose
    @Column(name = "bday", columnDefinition = "TINYINT")
    public String day;

    @Expose
    @Column(name = "bmonth", columnDefinition = "TINYINT")
    public String month;

    @Expose
    @Column(name = "byear", columnDefinition = "TINYINT")
    public String year;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    @Transient
    public String allPhones;

    @Transient
    public String allMails;

    @Transient
    @Column(name = "photo", columnDefinition = "mediumtext")
    public String photo;

    @XStreamOmitField
    @Id
    @Column(name = "id")
    public int id;

    public Groups getGroups() {
        return new Groups(groups);
    }

    public File getPhoto() {
        return new File(photo);
    }

    public String getAllPhones() {
        return allPhones;
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

    public String getWork() {
        return work;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
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

    public int getId() {
        return id;
    }

    public String getAllMails() {
        return allMails;
    }

    public UserInfo withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public UserInfo withAllMails(String allMails) {
        this.allMails = allMails;
        return this;
    }

    public UserInfo withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
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

    public UserInfo withWork(String work) {
        this.work = work;
        return this;
    }

    public UserInfo withEmail(String email) {
        this.email1 = email;
        return this;
    }

    public UserInfo withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public UserInfo withEmail3(String email3) {
        this.email3 = email3;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return id == userInfo.id && Objects.equals(name, userInfo.name) && Objects.equals(middlename, userInfo.middlename)
                && Objects.equals(lastname, userInfo.lastname) && Objects.equals(company, userInfo.company)
                && Objects.equals(address, userInfo.address) && Objects.equals(home, userInfo.home)
                && Objects.equals(mobile, userInfo.mobile) && Objects.equals(work, userInfo.work)
                && Objects.equals(email1, userInfo.email1) && Objects.equals(email2, userInfo.email2)
                && Objects.equals(email3, userInfo.email3) && Objects.equals(day, userInfo.day)
                && Objects.equals(month, userInfo.month) && Objects.equals(year, userInfo.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, middlename, lastname, company, address, home, mobile, work, email1, email2, email3, day, month, year, id);
    }

    public UserInfo inGroups(GroupData group) {
        groups.add(group);
        return this;
    }
}
