package com.gift.ajay.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest
{
    private String id;
    private String username;
    private String email;
    private String password;
    // private String gift_category;
}
