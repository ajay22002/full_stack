package com.gift.ajay.service;

import  com.gift.ajay.dto.request.UserRequest;
import  com.gift.ajay.dto.response.BasicResponse;
import  com.gift.ajay.dto.response.UserResponse;

public interface UserService {
     BasicResponse<UserResponse> getAllUser();
     BasicResponse<UserResponse> deleteuser(String id);
     UserResponse updateUser(String id,UserRequest request);
}