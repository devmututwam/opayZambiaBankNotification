package com.opay.opaybanknotification.endpoint;

import com.opay.opaybanknotification.dto.TransactionDto;
import lombok.extern.log4j.Log4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Get transaction EndPoint
 * @Author MututwaM
 */
@Log4j
@RestController
@RequestMapping("/services")
public class TransactionEndPoint {

    private final Environment env;

    public TransactionEndPoint(Environment env) {
        this.env = env;
    }


    @PostMapping(value = "/opay/bankNotifcation", produces = "application/json")
    public List<String> getTransactionDetails(@RequestBody TransactionDto reqForInforFromCmsDto) {

        Map<String, Object> response = new HashMap<>();

        List<String> responseList = new ArrayList<>();

        try {
            response = initCustomsReqForInfoService.initiateRequsetForInforl( reqForInforFromCmsDto );
        }
        catch (Exception e) {
            response.putIfAbsent( ResponseConstants.ERRORS, e.getCause() );
            response.putIfAbsent( ResponseConstants.STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value() );
            response.putIfAbsent( ResponseConstants.MESSAGE, "Server encountered an exception while processing your request" );

            responseList.add( 0, ResponseConstants.STATUS_ERROR );
            responseList.add( 1, "Server encountered an exception while processing your request" );

            return responseList;
        }
        responseList.add( 0, ResponseConstants.STATUS_SUCCESS );
        responseList.add( 1, String.valueOf( response.get( "transactionNumber" ) ) );

        return responseList;
    }


    //End of class
}
