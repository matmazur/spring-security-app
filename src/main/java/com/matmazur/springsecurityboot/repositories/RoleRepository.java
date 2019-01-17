package com.matmazur.springsecurityboot.repositories;

import com.matmazur.springsecurityboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
