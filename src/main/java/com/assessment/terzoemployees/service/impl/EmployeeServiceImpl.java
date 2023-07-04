package com.assessment.terzoemployees.service.impl;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;
import com.assessment.terzoemployees.repository.EmployeeRepository;
import com.assessment.terzoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.assessment.terzoemployees.mapper.Mapper.mapToEmployeeDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findEmployeeByID(Long employeeId) {
        EmployeeDto employeeDto = mapToEmployeeDto(employeeRepository.findById(employeeId).get());
        return employeeDto;
    }
}
