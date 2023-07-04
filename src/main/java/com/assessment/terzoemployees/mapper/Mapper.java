package com.assessment.terzoemployees.mapper;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;

public class Mapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .photoUrl(employee.getPhotoUrl())
                .joinedOn(employee.getJoinedOn())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .password(employee.getPassword())
                .roles(employee.getRoles())
                .build();
        return employeeDto;
    }
}
