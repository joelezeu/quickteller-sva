package com.joeleze.service;

import com.joeleze.domain.CustomerValidation;
import com.joeleze.domain.Customers;
import com.joeleze.service.impl.QuickTellerSVAImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuickTellerSVATest {

    @Test
    public void assertThatQuickTellerIsNotNull() throws Exception{
        String clientId = "IKIAE4669CD887A0AECF3434EBD829617582B4267FAC";
        String secret = "0n8A31zauWbDHGIijRKbUWij/1YFYNwjSbGI/y4hePU=";
        String terminalId = "3DMO0001";
        QuickTellerSVA quickTellerSVA = new QuickTellerSVAImpl(clientId,secret, terminalId);

        CustomerValidation customerValidationRequest = new CustomerValidation();

        List<Customers> customersList = new ArrayList<Customers>();
        Customers customers = new Customers();
        customers.setCustomerId("0434556574");
        customers.setPaymentCode("13701");

        customersList.add(customers);

        customerValidationRequest.setCustomers(customersList);

        Assert.assertNotNull(quickTellerSVA.customerValidation(customerValidationRequest));
    }
}
