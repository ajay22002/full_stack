package com.gift.ajay.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.EXPECTATION_FAILED;
import com.gift.ajay.Utils.myconstant;
import com.gift.ajay.dto.request.LoginRequest;
import com.gift.ajay.dto.request.RegisterRequest;
import com.gift.ajay.dto.response.LoginResponse;
import com.gift.ajay.dto.response.RegisterResponse;
import com.gift.ajay.service.AuthenticationService;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping(myconstant.REGISTER)
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse();
        try {
            response = authenticationService.register(request);
            return new ResponseEntity<>(response, ACCEPTED);
        } catch(Exception e) {
            response.setMessage("Something went Wrong!");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);
        }
    }

    @PostMapping(myconstant.LOGIN)
    public ResponseEntity <LoginResponse> login(@RequestBody LoginRequest request){
        LoginResponse response=new LoginResponse();
        try{
            response=authenticationService.login(request);
            return new ResponseEntity<>(response,ACCEPTED);
        }catch(Exception e){
            // LoginResponse.builder().message("Something went Wrong!").token("").build();
            System.out.println(e);
            response.setMessage("Something went wrong!!!!!!!!!!!");
            response.setToken("");
            return new ResponseEntity<>(response, EXPECTATION_FAILED);
        }
    }
}