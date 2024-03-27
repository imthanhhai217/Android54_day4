package com.devpro.android54_day4.models;

public class User {
    private String userName,address, avatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User(String userName, String address, String avatar) {
        this.userName = userName;
        this.address = address;
        this.avatar = avatar;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
