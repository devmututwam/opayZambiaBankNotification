package com.opay.opaybanknotification.api;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j;

/**
 * Get transaction API
 * @Author MututwaM
 */
@Component
@Log4j
public class TransactionApi {

    private final Environment env;

    public TransactionApi(Environment env) {
        this.env = env;
    }

    


    //End of class
}
