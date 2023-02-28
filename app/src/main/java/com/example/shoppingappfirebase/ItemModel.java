package com.example.shoppingappfirebase;

public class ItemModel {
    String username,group;
    Long phoneNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ItemModel(String username, Long phoneNumber, String group) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.group = group;
    }

    public ItemModel(){

    }
}
