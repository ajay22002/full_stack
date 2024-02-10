package com.gift.ajay.config;

import org.springframework.stereotype.Component;

import com.gift.ajay.Model.User;
import com.gift.ajay.enumerated.Role;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import com.gift.ajay.repository.UserRepository;


@Component
@RequiredArgsConstructor
@SuppressWarnings("null")

public class UserCli implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0) {
            return;
        }

        User user = User.builder()
                .name("Admin")
                .email("admin123@gmail.com")
                .password(passwordEncoder.encode("admin@123"))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);
    }
}