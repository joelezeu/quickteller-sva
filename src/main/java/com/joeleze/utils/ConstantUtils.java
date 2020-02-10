package com.joeleze.utils;

public class ConstantUtils {
    private static final String BASE_URL = "https://saturn.interswitchng.com";
    public static final String CUSTOMER_VALIDATION_URL = BASE_URL + "/api/v2/quickteller/customers/validations";
    public static final String PAYMENT_ADVISE = BASE_URL + "/api/v2/quickteller/payments/advices";
    public static final String QUERY_TRANSACTION = BASE_URL + "/api/v2/quickteller/transactions?requestreference=";
    public static final String PAYMENT_ITEMS = BASE_URL+"/api/v2/quickteller/billers/104/paymentitems";
}
