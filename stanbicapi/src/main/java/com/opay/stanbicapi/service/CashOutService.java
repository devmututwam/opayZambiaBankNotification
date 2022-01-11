package com.opay.stanbicapi.service;


import com.opay.stanbicapi.dto.CashOutRequestDto;
import com.opay.stanbicapi.dto.CashOutResponseDto;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Cash In Service
 * This class manages the request to process a cash out request from Opay E-Wallet
 * @Author MututwaM
 */
@Service
public class CashOutService {


    public CashOutResponseDto processCashOutRequest(CashOutRequestDto cashOutRequestDto){

        CashOutResponseDto response = new CashOutResponseDto();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        //validate to ensure the request object is not null before processing the date
        if(Objects.isNull(cashOutRequestDto)){
            response.setStatus(ResponseConstants.STATUS_ERROR);
            response.setMessage("No information received. Request object is empty");
            return response;
        }

        //Do the processing here
        /**
         * Fetch the required data here
         * and populate response Data Transfer Object here
         * then return the response
         */








        //Set the response parameters here
        response.setTimestamp(currentTime);

        return response;
    }

    //End of class
}
