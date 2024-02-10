package com.gift.ajay.dto.response;

import java.util.List;
import java.util.Collections; 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.gift.ajay.Model.Gift;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GiftResponse {
    private String message;
    private String gift_id;
    private String gift_name;
    private String gift_price;
    private String gift_image;
    private String gift_rating;
}
