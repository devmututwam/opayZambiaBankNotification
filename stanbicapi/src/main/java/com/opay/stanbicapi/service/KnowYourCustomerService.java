package com.opay.stanbicapi.service;


import com.opay.stanbicapi.dto.KycDto;
import com.opay.stanbicapi.dto.TransactionDto;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class KnowYourCustomerService {


    /**
     * Service method to extract the details given the customer mobile number
     * @param mobileNumber
     * @return kycDto
     */
    public KycDto getCustomerDetails(String mobileNumber){

        KycDto response = new KycDto();

        Timestamp curentTime = new Timestamp(System.currentTimeMillis());

        if("".equalsIgnoreCase(mobileNumber)){
            response.setStatus(ResponseConstants.STATUS_ERROR);
            response.setMessage("No information received. Mobile number field empty");
            return response;
        }

        //Do the processing here
        /**
         * Fetch the Customer Details from the database
         * and populate response Data Transfer Object here
         * then return the response
         */


        return response;
    }

    //End of class
}
