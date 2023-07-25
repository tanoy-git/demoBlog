package com.example.demo.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    Optional<EmployeeDto> getEmployeeById(Long employeeId);

    EmployeeDto createEmployee(EmployeeCreateDto input);

    void updateEmployee(EmployeeDto input);

    void deleteEmployee(Long employeeId);

    List<EmployeeDto> getEmployeesByDesignation(String designation);
}
