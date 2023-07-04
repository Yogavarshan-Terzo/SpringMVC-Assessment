package com.assessment.terzoemployees.service;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto findEmployeeByID(Long employeeId);
}
