package model;

import java.io.Serializable;

public class AccountAndInformation implements Serializable {
    private String id;
    private String userName;
    private String password;
    private int role;
    private String name;
    private String age;
    private int gender;

    public AccountAndInformation(String id, String userName, String password, int role, String name, String age, int gender) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID = '" + id + '\'' +
                ", username = '" + userName + '\'' +
                ", password = '" + password + '\'' +
                ", role = " + role +
                ", name = '" + name + '\'' +
                ", age = '" + age + '\'' +
                ", gender = " + gender;
    }
}