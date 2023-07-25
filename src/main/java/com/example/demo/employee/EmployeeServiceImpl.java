package com.example.demo.employee;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return EmployeeDto.fromEmployees(employees);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeId(employeeId);

        return employeeOptional.map(EmployeeDto::fromEmployee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeCreateDto input) {
        Employee employee = input.toEmployee();
        Optional<Long> lastEmployeeId = employeeRepository.findLastEmployeeId();

        if (lastEmployeeId.isPresent()) {
            employee.setEmployeeId(lastEmployeeId.get() + 1);
        } else {
            employee.setEmployeeId(1L);
        }

        employee.setJoiningDate(LocalDate.now());

        Employee newEmployee = employeeRepository.save(employee);

        return EmployeeDto.fromEmployee(newEmployee);

    }

    @Override
    public void updateEmployee(EmployeeDto input) {

        Employee employee = employeeRepository.findByEmployeeId(input.employeeId()).orElseThrow();

        employee.setName(input.name());
        employee.setDesignation(Designation.valueOf(input.designation()));

        employeeRepository.save(employee);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow();

        employeeRepository.delete(employee);

    }

    @Override
    public List<EmployeeDto> getEmployeesByDesignation(String designation) {
        List<Employee> employees = employeeRepository.getByDesignation(Designation.valueOf(designation));

        return EmployeeDto.fromEmployees(employees);
    }
}
