package com.assessment.terzoemployees.mapper;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;

public class Mapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .photoUrl(employee.getPhotoUrl())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .roles(employee.getRoles())
                .build();
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .photoUrl(employeeDto.getPhotoUrl())
                .email(employeeDto.getEmail())
                .designation(employeeDto.getDesignation())
                .roles(employeeDto.getRoles())
                .build();
        return employee;

    }
}
