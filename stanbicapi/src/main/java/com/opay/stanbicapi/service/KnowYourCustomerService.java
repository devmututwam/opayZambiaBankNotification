package com.opay.stanbicapi.service;


import com.opay.stanbicapi.dto.KnowYourCustmomerDto;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Know Your Customer Service
 * This class manages the request to get customer details
 * @Author MututwaM
 */
@Service
public class KnowYourCustomerService {


    /**
     * Service method to extract the details given the customer mobile number
     * @param mobileNumber
     * @return kycDto
     */
    public KnowYourCustmomerDto getCustomerDetails(String mobileNumber){

        KnowYourCustmomerDto response = new KnowYourCustmomerDto();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        //validate to ensure the mobile number field is not empty
        if("".equalsIgnoreCase(mobileNumber)){
            response.setStatus(ResponseConstants.STATUS_ERROR);
            response.setMessage("No information received. Mobile number field empty");
            return response;
        }

        //Do the processing here
        /**
         * Fetch the required data here
         * and populate response Data Transfer Object here
         * then return the response
         */










        return response;
    }

    //End of class
}
