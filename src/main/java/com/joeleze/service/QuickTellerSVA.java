package com.joeleze.service;

import com.joeleze.domain.CustomerValidation;

public interface QuickTellerSVA {
    CustomerValidation customerValidation(CustomerValidation customerValidationRequest) throws Exception;
}
