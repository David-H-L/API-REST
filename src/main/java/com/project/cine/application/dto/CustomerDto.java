package com.project.cine.application.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {
    final String name;
    final int age;
    final int email;
    final int customerPoints;

    public CustomerDto(String name, int age, int email, int customerPoints) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.customerPoints = customerPoints;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getEmail() {
        return email;
    }

    public int getCustomerPoints() {
        return customerPoints;
    }

}