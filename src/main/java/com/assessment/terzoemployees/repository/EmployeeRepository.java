package com.assessment.terzoemployees.repository;

import com.assessment.terzoemployees.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT E FROM Employee E WHERE E.name LIKE CONCAT('%',:query,'%')")
    List<Employee> searchEmployees(String query);
}
