package com.assessment.terzoemployees.service;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    Employee findEmployeeByID(Long employeeId);

    void saveEmployee(Employee employee);

    EmployeeDto findClubById(Long employeeId);

    void updateEmployee(EmployeeDto employeeDto);
    void delete(EmployeeDto employeeDto);
}
