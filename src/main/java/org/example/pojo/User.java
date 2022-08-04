package org.example.pojo;

public class User {
    private String User;

    private Integer age;

    public User(String user, Integer age) {
        User = user;
        this.age = age;
    }

    public User() {
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
