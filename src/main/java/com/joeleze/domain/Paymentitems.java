package com.joeleze.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Paymentitems {
    private String categoryid;
    private String billerid;
    private String paymentitemname;
    private String amount;

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getBillerid() {
        return billerid;
    }

    public void setBillerid(String billerid) {
        this.billerid = billerid;
    }

    public String getPaymentitemname() {
        return paymentitemname;
    }

    public void setPaymentitemname(String paymentitemname) {
        this.paymentitemname = paymentitemname;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
