package com.opay.opaybanknotification.service;


import com.opay.opaybanknotification.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GetTransactionService {


    public Map<String, Object> getTransaction(TransactionDto transactionDto){

        Map<String, Object> response = new HashMap<>();

        return response;
    }



    //End of class
}
