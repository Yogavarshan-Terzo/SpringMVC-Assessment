package com.assessment.terzoemployees.dto;

import com.assessment.terzoemployees.models.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String photoUrl;
    private String email;
    private String designation;
    private LocalDateTime joinedOn;
    List<Role> roles;
}
