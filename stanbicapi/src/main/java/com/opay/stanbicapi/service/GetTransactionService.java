package com.opay.stanbicapi.service;


import com.opay.stanbicapi.api.TransactionApi;
import com.opay.stanbicapi.dto.TransactionDto;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class GetTransactionService {

    private final TransactionApi transactionApi;

    public GetTransactionService(TransactionApi transactionApi) {
        this.transactionApi = transactionApi;
    }

    /**
     * method to extract the received transaction params
     * @param transactionDto
     * @return
     */
    public Map<String, Object> getTransaction(TransactionDto transactionDto){

        Map<String, Object> response = new HashMap<>();

        Timestamp curentTime = new Timestamp(System.currentTimeMillis());

        if(Objects.isNull(transactionDto)){
            response.put(ResponseConstants.STATUS, ResponseConstants.STATUS_ERROR);
            response.put(ResponseConstants.MESSAGE, "No information received");
            return response;
        }

        //Do the processing here


        //send the notice here if everything is successfull
        transactionApi.sendBankNotification(transactionDto);


        return response;
    }



    //End of class
}
