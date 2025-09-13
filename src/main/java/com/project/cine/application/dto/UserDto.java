package com.project.cine.application.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

    final String name;
    final int age;
    final String email;

    public UserDto(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

}
