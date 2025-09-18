package com.project.cine.domain.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "position")
public class PositionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_position")
    private Long idPosition;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeModel> employees;

    public Long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Long idPosition) {
        this.idPosition = idPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
    }
}
