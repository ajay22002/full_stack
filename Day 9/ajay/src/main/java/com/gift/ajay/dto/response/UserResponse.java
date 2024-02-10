package com.gift.ajay.dto.response;

import com.gift.ajay.enumerated.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String message;
    private String id;
    private String username;
    private Role role;
}
