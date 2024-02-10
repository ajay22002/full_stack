package com.gift.ajay.service;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.gift.ajay.Utils.JwtUtil;
import com.gift.ajay.dto.request.LoginRequest;
import com.gift.ajay.dto.request.RegisterRequest;
import com.gift.ajay.dto.response.LoginResponse;
import com.gift.ajay.dto.response.RegisterResponse;
import com.gift.ajay.enumerated.Role;
import com.gift.ajay.Model.User;
import com.gift.ajay.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.var;


@Service
@RequiredArgsConstructor
// @SuppressWarnings("null")
public class AuthenticationSericeImp implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtUtil jwtutil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest request) {
        Optional<User> isUserExists = userRepository.findByEmail(request.getEmail());
        if (isUserExists.isPresent()) {
            return RegisterResponse.builder()
                .message("User with email id " + request.getEmail() + " already exists")
                .build();
        }
        var user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
        userRepository.save(user);
        return RegisterResponse.builder()
            .message("User created successfully")
            .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        // TODO Auto-generated method stub
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user=userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtutil.generateToken(user);
        return LoginResponse.builder()
        .message("User logged in Suuccessfully")
        .token(token)
        .build();
        
    }
    
}