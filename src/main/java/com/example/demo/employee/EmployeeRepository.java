package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> getByDesignation(Designation designation);

    Optional<Employee> findByEmployeeId(Long employeeId);

    @Query(value = "select max(employee_id) from employee", nativeQuery = true)
    Optional<Long> findLastEmployeeId();
}
