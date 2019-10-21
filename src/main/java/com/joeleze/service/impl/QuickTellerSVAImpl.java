package com.joeleze.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joeleze.domain.BillPaymentAdvise;
import com.joeleze.domain.CustomerValidation;
import com.joeleze.service.QuickTellerSVA;
import com.joeleze.utils.ConstantUtils;
import com.joeleze.utils.HttpUtils;

public class QuickTellerSVAImpl implements QuickTellerSVA {

    private ObjectMapper objectMapper = new ObjectMapper();

    private String quicktellerClientId;
    private String quicktellerClientSecret;
    private String terminalId;

    public QuickTellerSVAImpl(String quicktellerClientId, String quicktellerClientSecret,String terminalId){
        this.quicktellerClientId = quicktellerClientId;
        this.quicktellerClientSecret = quicktellerClientSecret;
        this.terminalId = terminalId;
    }

    public CustomerValidation customerValidation(CustomerValidation customerValidationRequest) throws Exception {
        String response = new HttpUtils().postClient(ConstantUtils.CUSTOMER_VALIDATION_URL, customerValidationRequest, quicktellerClientId, quicktellerClientSecret, terminalId);
        if(response!= null){
            return objectMapper.readValue(response, CustomerValidation.class);
        }
        return null;
    }

    public BillPaymentAdvise paymentAdvise(BillPaymentAdvise billPaymentAdvise) throws Exception {
        billPaymentAdvise.setTerminalId(terminalId);
        String response = new HttpUtils().postClient(ConstantUtils.PAYMENT_ADVISE, billPaymentAdvise, quicktellerClientId, quicktellerClientSecret, terminalId);
        if(response!= null){
            return objectMapper.readValue(response, BillPaymentAdvise.class);
        }
        return null;
    }
}
