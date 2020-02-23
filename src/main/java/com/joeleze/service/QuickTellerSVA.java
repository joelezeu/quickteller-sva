package com.joeleze.service;

import com.joeleze.domain.BillPaymentAdvise;
import com.joeleze.domain.BillPaymentStatus;
import com.joeleze.domain.BouquetsListItems;
import com.joeleze.domain.CustomerValidation;

public interface QuickTellerSVA {
    CustomerValidation customerValidation(CustomerValidation customerValidationRequest) throws Exception;

    BillPaymentAdvise paymentAdvise(BillPaymentAdvise billPaymentAdvise) throws Exception;

    BillPaymentStatus billPaymentStatus(String reference) throws Exception;

    BouquetsListItems getBouquet(String alias) throws Exception;

    BouquetsListItems getAirtime(String alias) throws Exception;

    BouquetsListItems getDataPlans(String alias) throws Exception;
}
