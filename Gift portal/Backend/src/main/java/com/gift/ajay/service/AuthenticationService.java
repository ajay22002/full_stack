package com.gift.ajay.service;

import com.gift.ajay.dto.request.LoginRequest;
import com.gift.ajay.dto.request.RegisterRequest;
import com.gift.ajay.dto.response.LoginResponse;
import com.gift.ajay.dto.response.RegisterResponse;

public interface AuthenticationService {

     RegisterResponse register(RegisterRequest request);
     LoginResponse login(LoginRequest request);
    
}