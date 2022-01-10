package com.opay.stanbicapi.dto;

import java.math.BigDecimal;

/**
 * Transaction Data Transfer Object
 * @Author MututwaM
 */
public class TransactionDto {

    private String mobileNumber;
    private String bankId;
    private BigDecimal amount;
    private String refNumber;
    private String extRefNumber;
    private String trid;

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

    public String getTrid() {
        return trid;
    }

    public void setTrid(String trid) {
        this.trid = trid;
    }
}
