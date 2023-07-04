package com.assessment.terzoemployees.controller;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;
import com.assessment.terzoemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employees";
    }

    @GetMapping("employees/{employeeId}")
    public String employeeDetails(@PathVariable("employeeId") Long employeeId,Model model){
        EmployeeDto employeeDto = employeeService.findEmployeeByID(employeeId);
        model.addAttribute("employee",employeeDto);
        return "employee-detail";
    }
    @GetMapping("/employees/new")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee-add";
    }
//    @PostMapping("/employees/new")
//    public String saveClub(@Valid @ModelAttribute("club") EmployeeDto employeeDto, BindingResult result, Model model){
//        if(result.hasErrors()){
//            model.addAttribute("club",employeeDto);
//            return "employee-create";
//        }
//        employeeService.saveEmployee(clubDto);
//        return "redirect:/clubs";
//    }
}