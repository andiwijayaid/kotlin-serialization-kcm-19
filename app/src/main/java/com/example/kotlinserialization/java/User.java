package com.example.kotlinserialization.java;

public class User {
    private String name;
    private String email;
    private int age;
    private String placeOfBirth;

    public User(String name, String email, int age, String placeOfBirth) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.placeOfBirth = placeOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}
