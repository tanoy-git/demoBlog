package com.example.demo.employee;

public record EmployeeCreateDto(String name, Designation designation) {
    Employee toEmployee() {
        Employee employee = new Employee();

        employee.setName(name);
        employee.setDesignation(designation);

        return employee;
    }
}
