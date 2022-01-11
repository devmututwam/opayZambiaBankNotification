package com.opay.stanbicapi.endpoint;


import com.opay.stanbicapi.dto.CashInRequestDto;
import com.opay.stanbicapi.dto.CashInResponseDto;
import com.opay.stanbicapi.service.CashInRequestService;
import com.opay.stanbicapi.utils.ResponseConstants;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
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
public class CashInEndpoint {

    private final Environment env;
    private final CashInRequestService cashInRequestService;

    public CashInEndpoint(Environment env,
                          CashInRequestService cashInRequestService) {
        this.env = env;
        this.cashInRequestService = cashInRequestService;
    }

    /**
     * CashIn Endpoint method
     * @param cashInRequestDto
     * @param result
     * @return
     */
    @PostMapping(value = "/opay/cashIn", produces = "application/json")
    public CashInResponseDto opayCashInWallet(@RequestBody CashInRequestDto cashInRequestDto, BindingResult result) {

        CashInResponseDto cashInResponseDto = new CashInResponseDto();

        try {
            cashInResponseDto = cashInRequestService.processCashInRequest(cashInRequestDto);
        } catch (Exception e) {

            cashInResponseDto.setStatus(ResponseConstants.STATUS_ERROR);
            cashInResponseDto.setStatusCode(HttpStatus.BAD_REQUEST.toString());
            e.printStackTrace();

            return cashInResponseDto;
        }

        cashInResponseDto.setStatus(ResponseConstants.STATUS_SUCCESS);
        cashInResponseDto.setStatusCode(HttpStatus.OK.toString());

        return cashInResponseDto;
    }



    //End of class
}
