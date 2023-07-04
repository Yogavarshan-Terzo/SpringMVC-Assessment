package com.assessment.terzoemployees.controller;


import com.assessment.terzoemployees.dto.RegistrationDto;
import com.assessment.terzoemployees.models.UserEntity;
import com.assessment.terzoemployees.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user, BindingResult result,Model model){
        UserEntity existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email","error.user","User already exist in this email");
        }
        existingUser = userService.findByUserName(user.getUsername());
        if(existingUser != null && existingUser.getUsername()  != null && !existingUser.getUsername().isEmpty()){
            result.rejectValue("userName","error.user","Username already exists");
        }
        if(result.hasErrors()){
            model.addAttribute("user",user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/employees?success";
    }


}
