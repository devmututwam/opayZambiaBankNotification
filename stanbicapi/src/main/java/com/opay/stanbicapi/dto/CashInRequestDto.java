package com.opay.stanbicapi.dto;


import java.math.BigDecimal;

/**
 * Cash In Request Data Transfer Object
 * @Author MututwaM
 */
public class CashInRequestDto {

    public String mobileNumber;
    public String bankId;
    public BigDecimal amount;
    public String refNumber;
    public String extRefNumber;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
