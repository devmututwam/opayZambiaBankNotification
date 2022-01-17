package com.opay.stanbicapi.endpoint;


import com.opay.stanbicapi.dto.KYCRequestDto;
import com.opay.stanbicapi.dto.KnowYourCustmomerDto;
import com.opay.stanbicapi.service.KnowYourCustomerService;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
     * @param kycRequestDto
     * @param result
     * @return responseKycDto
     */
    @PostMapping(value = "/opay/kyc", produces = "application/json")
    public KnowYourCustmomerDto getCustomerDetails(@RequestBody KYCRequestDto kycRequestDto, BindingResult result) {

        KnowYourCustmomerDto responseKnowYourCustmomerDto = new KnowYourCustmomerDto();

        try {
            responseKnowYourCustmomerDto = knowYourCustomerService.getCustomerDetails(kycRequestDto);
        } catch (Exception e) {

            responseKnowYourCustmomerDto.setStatus(ResponseConstants.STATUS_ERROR);
            e.printStackTrace();

            return responseKnowYourCustmomerDto;
        }

        responseKnowYourCustmomerDto.setStatus(ResponseConstants.STATUS_SUCCESS);

        return responseKnowYourCustmomerDto;
    }


    //End of class
}
