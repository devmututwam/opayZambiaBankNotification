package com.opay.stanbicapi.endpoint;


import com.opay.stanbicapi.dto.KycDto;
import com.opay.stanbicapi.service.KnowYourCustomerService;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Know Your Customer EndPoint
 * @Author MututwaM
 */
@RestController
@RequestMapping("/services")
public class KnowYourCustomerEndpoint {

    private final Environment env;
    private final KnowYourCustomerService knowYourCustomerService;

    public KnowYourCustomerEndpoint(Environment env,
                                    KnowYourCustomerService knowYourCustomerService) {
        this.env = env;
        this.knowYourCustomerService = knowYourCustomerService;
    }


    /**
     * Application Endpoint to fetch customer details
     * @param mobileNumber
     * @param result
     * @return responseKycDto
     */
    @PostMapping(value = "/opay/kyc", produces = "application/json")
    public KycDto getCustomerDetails(@RequestBody String mobileNumber, BindingResult result) {

        KycDto responseKycDto = new KycDto();

        try {
            responseKycDto = knowYourCustomerService.getCustomerDetails(mobileNumber);
        } catch (Exception e) {

            responseKycDto.setStatus(ResponseConstants.STATUS_ERROR);

            return responseKycDto;
        }

        responseKycDto.setStatus(ResponseConstants.STATUS_SUCCESS);

        return responseKycDto;
    }


    //End of class
}
