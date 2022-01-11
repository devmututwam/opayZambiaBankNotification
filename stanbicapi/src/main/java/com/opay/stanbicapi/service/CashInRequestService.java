package com.opay.stanbicapi.service;


import com.opay.stanbicapi.dto.CashInRequestDto;
import com.opay.stanbicapi.dto.CashInResponseDto;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;


/**
 * Cash In Service
 * This class manages the request to process a cash in request from bank to Opay E-Wallet
 * @Author MututwaM
 */
@Service
public class CashInRequestService {


    /**
     *
     * @param cashInRequestDto
     * @return
     */
    public CashInResponseDto processCashInRequest(CashInRequestDto cashInRequestDto){

        CashInResponseDto responseDto = new CashInResponseDto();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        //validate to ensure the request object is not null before processing the date
        if(Objects.isNull(cashInRequestDto)){
            responseDto.setStatus(ResponseConstants.STATUS_ERROR);
            responseDto.setMessage("No information received. Request object is empty");
            return responseDto;
        }

        //Do the processing here
        /**
         * Fetch the required data here
         * and populate response Data Transfer Object here
         * then return the response
         */









        //Set the response parameters here
        responseDto.setTimestamp(currentTime);

        return responseDto;
    }

    //End of class
}
