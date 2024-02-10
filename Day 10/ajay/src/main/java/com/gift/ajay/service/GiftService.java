package com.gift.ajay.service;

import com.gift.ajay.dto.request.GiftRequest;
import com.gift.ajay.dto.response.BasicResponse;
import com.gift.ajay.dto.response.GiftResponse;

public interface GiftService {
    BasicResponse<GiftResponse> getAllGifts();
    GiftResponse createGift(GiftRequest request);
    BasicResponse<GiftResponse> deleteGift(String Id);
    static BasicResponse<GiftResponse> updateGift(String Id, GiftRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGift'");
    }
}