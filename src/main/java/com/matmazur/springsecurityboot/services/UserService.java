package com.matmazur.springsecurityboot.services;

import com.matmazur.springsecurityboot.model.Role;
import com.matmazur.springsecurityboot.model.User;
import com.matmazur.springsecurityboot.repositories.RoleRepository;
import com.matmazur.springsecurityboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final static String DEFAULT_ROLE = "ROLE_USER";

    private final
    UserRepository userRepository;
    private final
    RoleRepository roleRepository;
    private final
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addWithDefaultRole(User user) {
        Role defaultRole = roleRepository.findByRoleName(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }
}
