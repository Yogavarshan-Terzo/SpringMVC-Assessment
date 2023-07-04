package com.assessment.terzoemployees.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Photo URL should not be empty")
    private String photoUrl;
    private String department;
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @NotEmpty(message = "Designation should not be empty")
    private String designation;
    @CreationTimestamp
    private LocalDateTime joinedOn;

}
