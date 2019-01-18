package com.matmazur.springsecurityboot.services;

import com.matmazur.springsecurityboot.model.Role;
import com.matmazur.springsecurityboot.model.User;
import com.matmazur.springsecurityboot.repositories.RoleRepository;
import com.matmazur.springsecurityboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final static String DEFAULT_ROLE = "ROLE_USER";
    private final static String ADMIN_ROLE = "ROLE_ADMIN";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addWithDefaultRole(User user) {
        Role userRole = roleRepository.findByRoleName(DEFAULT_ROLE);

        user.getRoles().add(userRole);
        hashPasswordAndAddUser(user);

    }

    public void addWithAdminRole(User user) {

        Role userRole = roleRepository.findByRoleName(DEFAULT_ROLE);
        Role adminRole = roleRepository.findByRoleName(ADMIN_ROLE);

        user.getRoles().addAll(Arrays.asList(userRole, adminRole));
        hashPasswordAndAddUser(user);

    }

    private void hashPasswordAndAddUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

}
