package com.assessment.terzoemployees.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photoUrl;
    private String password;
    private String email;
    private String designation;
    @CreationTimestamp
    private LocalDateTime joinedOn;
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    List<Role> roles;

}
