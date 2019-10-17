package com.joeleze.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerValidation {
    @JsonAlias({"Customers", "customers"})
    private List<Customers> customers;

    public CustomerValidation(){

    }

    public CustomerValidation(List<Customers> customers){
        this.customers = customers;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
}
