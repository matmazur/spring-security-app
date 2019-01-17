package com.matmazur.springsecurityboot.repositories;

import com.matmazur.springsecurityboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
