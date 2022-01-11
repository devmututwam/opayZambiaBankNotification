package com.opay.stanbicapi.endpoint;


import com.opay.stanbicapi.dto.CashOutRequestDto;
import com.opay.stanbicapi.dto.CashOutResponseDto;
import com.opay.stanbicapi.service.CashOutService;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CashIn EndPoint
 * From Bank to Opay Wallet
 * @Author MututwaM
 */
@RestController
@RequestMapping("/services")
public class CashOutEndpoint {

    private final Environment env;
    private final CashOutService cashOutService;

    public CashOutEndpoint(Environment env,
                           CashOutService cashOutService) {
        this.env = env;
        this.cashOutService = cashOutService;
    }


    /**
     * CashOut Endpoint method
     * @param cashOutRequestDto
     * @param result
     * @return
     */
    @PostMapping(value = "/opay/cashOut", produces = "application/json")
    public CashOutResponseDto opayCashOutWallet(@RequestBody CashOutRequestDto cashOutRequestDto, BindingResult result){

        CashOutResponseDto cashOutResponseDto = new CashOutResponseDto();

        try{
            cashOutResponseDto = cashOutService.processCashOutRequest(cashOutRequestDto);
        }catch(Exception e){

            cashOutResponseDto.setStatus(ResponseConstants.STATUS_ERROR);
            cashOutResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            e.printStackTrace();

            return cashOutResponseDto;
        }

        return cashOutResponseDto;
    }


    //End of class
}
