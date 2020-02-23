package com.joeleze.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joeleze.domain.BillPaymentAdvise;
import com.joeleze.domain.BillPaymentStatus;
import com.joeleze.domain.BouquetsListItems;
import com.joeleze.domain.CustomerValidation;
import com.joeleze.service.QuickTellerSVA;
import com.joeleze.utils.ConstantUtils;
import com.joeleze.utils.HttpUtils;

public class QuickTellerSVAImpl implements QuickTellerSVA {

    private ObjectMapper objectMapper = new ObjectMapper();

    private String quicktellerClientId;
    private String quicktellerClientSecret;
    private String terminalId;

    public QuickTellerSVAImpl(String quicktellerClientId, String quicktellerClientSecret, String terminalId) {
        this.quicktellerClientId = quicktellerClientId;
        this.quicktellerClientSecret = quicktellerClientSecret;
        this.terminalId = terminalId;
    }

    public CustomerValidation customerValidation(CustomerValidation customerValidationRequest) throws Exception {
        String response = new HttpUtils().postClient(ConstantUtils.CUSTOMER_VALIDATION_URL, customerValidationRequest, quicktellerClientId, quicktellerClientSecret, terminalId);
        if (response != null) {
            return objectMapper.readValue(response, CustomerValidation.class);
        }
        return null;
    }

    public BillPaymentAdvise paymentAdvise(BillPaymentAdvise billPaymentAdvise) throws Exception {
        billPaymentAdvise.setTerminalId(terminalId);
        String response = new HttpUtils().postClient(ConstantUtils.PAYMENT_ADVISE, billPaymentAdvise, quicktellerClientId, quicktellerClientSecret, terminalId);
        if (response != null) {
            return objectMapper.readValue(response, BillPaymentAdvise.class);
        }
        return null;
    }


    public BillPaymentStatus billPaymentStatus(String reference) throws Exception {
        String response = new HttpUtils().getClient(ConstantUtils.QUERY_TRANSACTION + reference, quicktellerClientId, quicktellerClientSecret, terminalId);
        if (response != null) {
            return objectMapper.readValue(response, BillPaymentStatus.class);
        }
        return null;
    }

    public BouquetsListItems getBouquet(String alias) throws Exception {
        String response = null;
        if (alias.trim().equalsIgnoreCase(ConstantUtils.PAYMENT_ITEMS_GOTV_)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_GOTV, quicktellerClientId, quicktellerClientSecret, terminalId);
        } else if (alias.trim().equals(ConstantUtils.PAYMENT_ITEMS_ALIAS)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS, quicktellerClientId, quicktellerClientSecret, terminalId);
        }
        if (alias.trim().equalsIgnoreCase(ConstantUtils.PAYMENT_ITEMS_STARTIMES)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_STARTTIME, quicktellerClientId, quicktellerClientSecret, terminalId);
        }
        if (alias.trim().equalsIgnoreCase(ConstantUtils.PAYMENT_ITEMS_IROKO)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_URL_IROKO, quicktellerClientId, quicktellerClientSecret, terminalId);
        }
        if (response != null) {
            return objectMapper.readValue(response, BouquetsListItems.class);
        }
        return null;
    }

    public BouquetsListItems getAirtime(String alias) throws Exception {
        String response = null;
        if (alias.trim().equalsIgnoreCase(ConstantUtils.PAYMENT_ITEMS_MTN)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_URL_MTN, quicktellerClientId, quicktellerClientSecret, terminalId);
        } else if (alias.trim().equals(ConstantUtils.PAYMENT_ITEMS_AIRTEL_)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_URL_AIRTEL, quicktellerClientId, quicktellerClientSecret, terminalId);
        }
        if (alias.trim().equalsIgnoreCase(ConstantUtils.PAYMENT_ITEMS_GLO)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_URL_GLO, quicktellerClientId, quicktellerClientSecret, terminalId);
        }
        if (alias.trim().equalsIgnoreCase(ConstantUtils.PAYMENT_ITEMS_9Mobile)) {
            response = new HttpUtils().getClient(ConstantUtils.PAYMENT_ITEMS_URL_9Mobile, quicktellerClientId, quicktellerClientSecret, terminalId);
        }
        if (response != null) {
            return objectMapper.readValue(response, BouquetsListItems.class);
        }
        return null;
    }
}
