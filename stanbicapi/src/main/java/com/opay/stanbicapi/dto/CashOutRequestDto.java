package com.opay.stanbicapi.dto;

import java.math.BigDecimal;

/**
 * Cash Out Request Data Transfer Object
 * @Author MututwaM
 */
public class CashOutRequestDto {

    public String mobileNumber;
    public BigDecimal amount;
    public String otp;
    public String refNumber;
    public String extRefNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getExtRefNumber() {
        return extRefNumber;
    }

    public void setExtRefNumber(String extRefNumber) {
        this.extRefNumber = extRefNumber;
    }
}
