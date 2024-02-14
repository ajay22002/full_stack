package com.gift.ajay.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.gift.ajay.service.GiftService;
import com.gift.ajay.Utils.myconstant;
import com.gift.ajay.dto.request.GiftRequest;
import com.gift.ajay.dto.response.BasicResponse;
import com.gift.ajay.dto.response.GiftResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(myconstant.GIFTS)
@RequiredArgsConstructor
public class GiftController {
    private final GiftService giftService;

    
    @GetMapping(myconstant.SHOWGIFT)
    public ResponseEntity<BasicResponse<GiftResponse>> create(){
        BasicResponse<GiftResponse> response=new BasicResponse<>();
        try{
            response=giftService.getAllGifts();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(Exception e){
            response.setMessage("Something went wrong!");
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
        }
    }

@PostMapping(myconstant.ADDGIFT)
    public ResponseEntity<GiftResponse> createGift(@RequestBody GiftRequest request) {
        GiftResponse response = new GiftResponse();
        try {
            response = giftService.createGift(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e) {
            response.setMessage("Something went Wrong!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(myconstant.DELETEGIFT + "/{Id}")
    public ResponseEntity<BasicResponse<GiftResponse>> deleteGift(@PathVariable String Id) {
        BasicResponse<GiftResponse> response = new BasicResponse<>();
        try {
            BasicResponse<GiftResponse> deletedGiftResponse = giftService.deleteGift(Id);
            response.setMessage(deletedGiftResponse.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Failed to delete booking: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(myconstant.UPDATEGIFT + "/{Id}")
public ResponseEntity<BasicResponse<GiftResponse>> updateGift(@PathVariable String Id, @RequestBody GiftRequest GiftRequest) {
    BasicResponse<GiftResponse> response = new BasicResponse<>();
    try {
        BasicResponse<GiftResponse> updatedGiftResponse = giftService.updateGift(Id,GiftRequest);
        response.setMessage(updatedGiftResponse.getMessage());
        response.setData(updatedGiftResponse.getData());
        return new ResponseEntity<>(response,HttpStatus. OK);
    } catch (Exception e) {
        response.setMessage("Failed to update booking: " + e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
}