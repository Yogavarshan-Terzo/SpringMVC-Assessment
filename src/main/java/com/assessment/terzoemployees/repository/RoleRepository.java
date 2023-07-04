package com.assessment.terzoemployees.repository;

import com.assessment.terzoemployees.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
