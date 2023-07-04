package com.assessment.terzoemployees.service;

import com.assessment.terzoemployees.dto.RegistrationDto;
import com.assessment.terzoemployees.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUserName(String username);
}
