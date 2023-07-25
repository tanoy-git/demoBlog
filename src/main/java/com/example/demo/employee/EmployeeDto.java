package com.example.demo.employee;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record EmployeeDto(Long id, String name, Long employeeId, LocalDate joiningDate, String designation,
                          Double salary) {

    public static EmployeeDto fromEmployee(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName(),
                employee.getEmployeeId(), employee.getJoiningDate(), employee.getDesignation(), employee.getSalary());
    }

    public static List<EmployeeDto> fromEmployees(List<Employee> employees) {
        return employees.stream().map(EmployeeDto::fromEmployee).collect(Collectors.toList());
    }

}