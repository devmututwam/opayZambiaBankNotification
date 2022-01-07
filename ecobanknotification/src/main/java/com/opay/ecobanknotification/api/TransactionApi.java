package com.opay.ecobanknotification.api;

import com.opay.ecobanknotification.dto.TransactionDto;
import com.opay.ecobanknotification.dto.TransactionNotifyDto;
import com.opay.ecobanknotification.service.SendTransactionService;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Logger;

/**
 * Get transaction API
 * @Author MututwaM
 */
@Component
public class TransactionApi {

    private final Environment env;
    private final SendTransactionService sendTransactionService;
    private Logger logger = Logger.getLogger(String.valueOf(TransactionApi.class));

    public TransactionApi(Environment env,
                          SendTransactionService sendTransactionService) {
        this.env = env;
        this.sendTransactionService = sendTransactionService;
    }


    /**
     * Send api notification
     * @param transactionDto
     * @return
     */
    public Map<String, Object> sendBankNotification(TransactionDto transactionDto){

        Map<String, Object> response = new HashMap<>();



        //Create and instance of the TransactionNotifyDto
        TransactionNotifyDto transactionNotifyDto = new TransactionNotifyDto();

        //Make the API call
        this.notifyBank(transactionNotifyDto);

        return response;
    }

    /**
     * Notify bank API method call
     * @param transactionNotifyDto
     * @return
     */
    public List<String> notifyBank(TransactionNotifyDto transactionNotifyDto){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<MultipartHttpServletRequest> requestHttpEntity = new HttpEntity(transactionNotifyDto, headers);

        ResponseEntity<Set<String>> response = null;

        String url = this.env.getProperty("targeIP");

        try {
            response = restTemplate.exchange(url, HttpMethod.POST, requestHttpEntity, new ParameterizedTypeReference<Set<String>>(){});
        }catch (Exception e){
            e.printStackTrace();
            //logger.error(e.getMessage(), e.getCause());
        }

        if(response == null){
            return new ArrayList<>();
        }

        Set<String> returnedValues;
        returnedValues = response.getBody();

        //###### API End #########
        List<String> responseList = new ArrayList<>();
        if(returnedValues == null){
            return new ArrayList<>();
        }else{
            responseList = new ArrayList<>(returnedValues);
        }

        return responseList;
    }
    


    //End of class
}
