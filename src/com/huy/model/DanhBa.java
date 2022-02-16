package com.huy.model;

import java.io.Serializable;
import java.time.LocalDate;

public class DanhBa implements Serializable {
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String group;
    private String birthday;

    public DanhBa() {
    }

    public DanhBa(String name, String gender, String address, String phoneNumber, String email, String group, String birthday) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.group = group;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDayOfBirth() {
        return birthday;
    }

    public void setDayOfBirth(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                ", dayOfBirth=" + birthday +
                '}';
    }
}

