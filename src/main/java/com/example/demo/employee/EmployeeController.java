package com.example.demo.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmployeeId(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId).orElseThrow(), HttpStatus.OK);
    }

    @GetMapping("/by-designation/{designation}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByDesignation(@PathVariable String designation) {
        return new ResponseEntity<>(employeeService.getEmployeesByDesignation(designation), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeCreateDto input) {
        return new ResponseEntity<>(employeeService.createEmployee(input), HttpStatus.CREATED);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeDto input) {
        if (!employeeId.equals(input.employeeId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        employeeService.updateEmployee(input);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
