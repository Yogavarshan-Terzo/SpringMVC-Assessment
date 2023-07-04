package com.assessment.terzoemployees.service.impl;

import com.assessment.terzoemployees.dto.RegistrationDto;
import com.assessment.terzoemployees.models.Role;
import com.assessment.terzoemployees.models.UserEntity;
import com.assessment.terzoemployees.repository.RoleRepository;
import com.assessment.terzoemployees.repository.UserRepository;
import com.assessment.terzoemployees.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
