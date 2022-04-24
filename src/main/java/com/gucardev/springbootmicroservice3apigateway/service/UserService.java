package com.gucardev.springbootmicroservice3apigateway.service;

import com.gucardev.springbootmicroservice3apigateway.model.Role;
import com.gucardev.springbootmicroservice3apigateway.model.User;
import com.gucardev.springbootmicroservice3apigateway.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreated(LocalDateTime.now());

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional //Transactional is required when executing an update/delete query.
    public void changeRole(Role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }


}
