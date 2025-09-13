package com.project.cine.application.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

    final String name;
    final int age;
    final String email;
    final double salary;
    final String address;
    final String phoneNumber;

    public EmployeeDto(String name, int age, String email, double salary, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
