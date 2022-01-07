package com.opay.ecobanknotification.endpoint;

import com.opay.ecobanknotification.dto.TransactionDto;
import com.opay.ecobanknotification.service.GetTransactionService;
import com.opay.ecobanknotification.utils.ResponseConstants;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
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
@RestController
@RequestMapping("/services")
public class TransactionEndPoint {

    private final Environment env;
    private final GetTransactionService getTransactionService;

    public TransactionEndPoint(Environment env,
                               GetTransactionService getTransactionService) {
        this.env = env;
        this.getTransactionService = getTransactionService;
    }


    /**
     * Get Transaction Endpoint
     * @param transactionDto
     * @return
     */
    @PostMapping(value = "/opay/bankNotifcation", produces = "application/json")
    public List<String> getTransactionDetails(@RequestBody TransactionDto transactionDto) {

        Map<String, Object> response = new HashMap<>();

        List<String> responseList = new ArrayList<>();

        try {
            response = getTransactionService.getTransaction(transactionDto);
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