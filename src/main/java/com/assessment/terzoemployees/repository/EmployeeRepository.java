package com.assessment.terzoemployees.repository;

import com.assessment.terzoemployees.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
