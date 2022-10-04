package com.freddy.apps.freddydemo;

public class UserDetailClass {

    private String userName = "Default Name";
    private int userAge = 30;

    //empty constructor
    public UserDetailClass() {

    }

    //constructor with default name
    public UserDetailClass(String userName) {
        this.userName = userName;
    }

    //constructor with default age
    public UserDetailClass(int userAge) {
        this.userAge = userAge;
    }

    //constructor with default name and age
    public UserDetailClass(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    //overloading example
    public String getUserName(String dummy) {
        return userName;
    }

    //overloading example
    public String getUserName(int dummy) {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int age) {
        userAge = age;
    }
}
