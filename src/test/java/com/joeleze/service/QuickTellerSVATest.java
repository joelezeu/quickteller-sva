package com.joeleze.service;

import com.joeleze.domain.BillPaymentAdvise;
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
        customers.setCustomerId("0000000001");
        customers.setPaymentCode("10401");

        customersList.add(customers);

        customerValidationRequest.setCustomers(customersList);

        Assert.assertNotNull(quickTellerSVA.customerValidation(customerValidationRequest));
    }

    @Test
    public void assertThatPaymentAdviseIsNotNull() throws Exception{
        String clientId = "IKIAE4669CD887A0AECF3434EBD829617582B4267FAC";
        String secret = "0n8A31zauWbDHGIijRKbUWij/1YFYNwjSbGI/y4hePU=";
        String terminalId = "3DMO0001";
        QuickTellerSVA quickTellerSVA = new QuickTellerSVAImpl(clientId,secret, terminalId);
        BillPaymentAdvise billPaymentAdvise = new BillPaymentAdvise();
        billPaymentAdvise.setAmount("72900");
        billPaymentAdvise.setCustomerEmail("joelezeu@gmail.com");
        billPaymentAdvise.setCustomerMobile("2348138249630");
        billPaymentAdvise.setCustomerId("0000000001");
        billPaymentAdvise.setPaymentCode("10401");
        billPaymentAdvise.setRequestReference("1453"+System.currentTimeMillis());

        Assert.assertNotNull(quickTellerSVA.paymentAdvise(billPaymentAdvise));
    }
}
