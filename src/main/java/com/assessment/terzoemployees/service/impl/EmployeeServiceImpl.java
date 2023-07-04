package com.assessment.terzoemployees.service.impl;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;
import com.assessment.terzoemployees.repository.EmployeeRepository;
import com.assessment.terzoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.assessment.terzoemployees.mapper.Mapper.mapToEmployee;
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
    public Employee findEmployeeByID(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto findClubById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return mapToEmployeeDto(employee);
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {
        Employee employee = mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(EmployeeDto employeeDto) {
        Employee employee=mapToEmployee(employeeDto);
        employeeRepository.deleteById(employee.getId());
    }

    @Override
    public List<EmployeeDto> searchEmployees(String query) {
        return employeeRepository.searchEmployees(query).stream().map(employee -> mapToEmployeeDto(employee)).collect(Collectors.toList());
    }
}
