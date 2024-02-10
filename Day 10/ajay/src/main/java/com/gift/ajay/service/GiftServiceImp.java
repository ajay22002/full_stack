package com.gift.ajay.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.gift.ajay.Model.Gift;
import com.gift.ajay.repository.GiftRepository;
import com.gift.ajay.dto.request.GiftRequest;
import com.gift.ajay.dto.response.BasicResponse;
import com.gift.ajay.dto.response.GiftResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GiftServiceImp implements GiftService {
    private final GiftRepository giftRepo;

    @Override
    public BasicResponse<GiftResponse> getAllGifts() 
    {
        List<Gift> gifts = giftRepo.findAll();
        List<GiftResponse> giftResponses = gifts.stream()
            .map(gift -> GiftResponse.builder()
                .gift_name(gift.getGift_name())
                .gift_price(gift.getGift_price())
                .build())
            .collect(Collectors.toList());
        return BasicResponse.<GiftResponse>builder()
            .message("success!")
            .data(giftResponses)
            .build();
    }

    private final GiftRepository giftRepository;
    @Override
    public GiftResponse createGift(GiftRequest request) {
        var gift = Gift.builder()
            .gift_name(request.getGift_name())
            .gift_price(request.getGift_price())
            .gift_image(request.getGift_image())
            .gift_rating(request.getGift_rating())
            .build();
        giftRepository.save(gift);
        return GiftResponse.builder()
            .message("Gift created successfully")
            .build();
    }
    @Override
        public BasicResponse<GiftResponse> deleteGift(String Id) {
            // TODO Auto-genated method stub
            if (giftRepo.existsById(Id)) {
                giftRepo.deleteById(Id);
                return BasicResponse.<GiftResponse>builder()
                    .message("Operator deleted successfully")
                    .build();
            } else {
                return BasicResponse.<GiftResponse>builder()
                    .message("Operator not found with ID: " + Id)
                    .build();
            }
        }



        @Override
        public BasicResponse<GiftResponse> updateGift(String Id, GiftRequest request) {
            // Retrieve the existing booking from the repository
            Gift existingOperator = giftRepo.findById(Id)
                    .orElseThrow(() -> new RuntimeException("Booking not found with id: " + Id));

            existingOperator.setId(request.getGift_id());;
            existingOperator.setGift_name(request.getGift_name());
            // existingOperator.setOperatorType(request.getOperatorType());

            giftRepo.save(existingOperator);
        
            // Construct and return the response
            GiftResponse updatedOperatedResponse = mapToBookingResponse( existingOperator);
            return BasicResponse.<GiftResponse>builder()
                    .message("Operator updated successfully")
                    .data(List.of(updatedOperatedResponse)) // Pass a list containing a single updated booking response
                    .build();
        }

        private GiftResponse mapToBookingResponse(Gift existingOperator) {
            // TODO Auto-generated method stub
            return GiftResponse.builder()
            // .id(existingOperator.getId())
           .gift_name(existingOperator.getGift_name())
            // .operatorType(existingOperator.getOperatorType())
            .build();
        }


}