package com.gift.ajay.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GiftRequest
{
    private String gift_id;
    private String gift_name;
    private String gift_price;
    private String gift_image;
    private String gift_rating;
}

    
