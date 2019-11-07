package com.joeleze.service;

import com.joeleze.domain.BillPaymentAdvise;
import com.joeleze.domain.BillPaymentStatus;
import com.joeleze.domain.CustomerValidation;

public interface QuickTellerSVA {
    CustomerValidation customerValidation(CustomerValidation customerValidationRequest) throws Exception;
    BillPaymentAdvise paymentAdvise(BillPaymentAdvise billPaymentAdvise) throws Exception;
    BillPaymentStatus billPaymentStatus(String reference) throws Exception;
}
