package com.assessment.terzoemployees.controller;

import com.assessment.terzoemployees.dto.EmployeeDto;
import com.assessment.terzoemployees.models.Employee;
import com.assessment.terzoemployees.models.UserEntity;
import com.assessment.terzoemployees.security.SecurityUtil;
import com.assessment.terzoemployees.service.EmployeeService;
import com.assessment.terzoemployees.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    EmployeeService employeeService;
    UserService userService;
    @Autowired
    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        UserEntity user = new UserEntity();
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUserName(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("employees",employees);
        return "employees";
    }

    @GetMapping("employees/{employeeId}")
    public String employeeDetails(@PathVariable("employeeId") Long employeeId,Model model){
        Employee employee = employeeService.findEmployeeByID(employeeId);
        model.addAttribute("employee",employee);
        return "employee-detail";
    }
    @GetMapping("/employees/new")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee-add";
    }
    @PostMapping("/employees/new")
    public String saveClub(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("employee",employee);
            return "employee-add";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{employeeId}/edit")
    public String editEmployeeForm(@PathVariable("employeeId") Long employeeId, Model model ){
        EmployeeDto employeeDto = employeeService.findClubById(employeeId);
        model.addAttribute("employee",employeeDto);
        return "employee-edit";
    }
    @PostMapping("/employees/{employeeId}/edit")
    public String updateEmployee(@PathVariable("employeeId") Long employeeId, @Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("employee",employeeDto);
            return "employee-edit";
        }
        employeeDto.setId(employeeId);
        employeeService.updateEmployee(employeeDto);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{employeeId}/delete")
    public String deleteEmployeeRedirect(@PathVariable("employeeId") Long employeeId, Model model ){
        EmployeeDto employeeDto = employeeService.findClubById(employeeId);
        model.addAttribute("employee",employeeDto);
        return "employee-detail-delete";
    }

    @GetMapping("/employees/{employeeId}/confirm/delete")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId, Model model ){
        EmployeeDto employeeDto = employeeService.findClubById(employeeId);
        employeeService.delete(employeeDto);
        return "redirect:/employees";
    }
    @GetMapping("/employees/search")
    public String searchClubs(@RequestParam(value = "query") String query, Model model){
        List<EmployeeDto> employees = employeeService.searchEmployees(query);
        model.addAttribute("employees",employees);
        return "employees";
    }

}
