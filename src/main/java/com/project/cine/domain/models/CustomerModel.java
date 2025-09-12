package com.project.cine.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
@PrimaryKeyJoinColumn(name = "id")

public class CustomerModel extends UserModel {

    @Column(nullable = false)
    private int customerPoints;

    public int getCustomerPoints() {
        return customerPoints;
    }

    public void setCustomerPoints(int customerPoints) {
        this.customerPoints = customerPoints;
    }

}
