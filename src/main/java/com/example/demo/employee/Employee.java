package com.example.demo.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long employeeId;

    private LocalDate joiningDate;

    private Designation designation;

    private Double salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDesignation() {
        return designation.name();
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
        this.salary = switch (designation) {

            case JuniorExecutive -> 25000d;
            case Executive -> 35000d;
            case SeniorExecutive -> 70000d;
        };
    }

    public Double getSalary() {
        return salary;
    }

}
