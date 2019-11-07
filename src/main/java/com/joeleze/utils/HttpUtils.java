package com.joeleze.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HttpUtils {
    private static final String signatureMethod = "SHA1";
    private final static Logger log = Logger.getLogger(HttpUtils.class.getName());

    public String postClient(String url, Object reqData, String quicktellerClientId, String quicktellerClientSecret, String terminalId) throws Exception {

        Utils utils = new Utils();
        long timestamp = utils.getCurrentTime();
        String nonce = utils.nonce();

        String signature = utils.signature(quicktellerClientId, quicktellerClientSecret, signatureMethod, url, timestamp, nonce, "POST");


        HttpClient client = HttpClientBuilder.create().build();

        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "InterswitchAuth " + Base64.encodeBase64String(quicktellerClientId.getBytes()));
        request.setHeader("Timestamp", "" + timestamp);
        request.setHeader("Nonce", nonce);
        request.setHeader("SignatureMethod", signatureMethod);
        request.setHeader("Signature", signature);
        request.setHeader("TerminalId", terminalId);

        String req = new ObjectMapper().writeValueAsString(reqData);
        log.log(Level.INFO, req);
        log.log(Level.INFO, url);


        request.setEntity(new StringEntity(req));
        HttpResponse serviceResponse = client.execute(request);

        log.log(Level.INFO, "" + serviceResponse.getStatusLine().getStatusCode());

        String resp = EntityUtils.toString(serviceResponse.getEntity());
        log.log(Level.INFO, resp);
        return resp;

    }

    public String getClient(String url, String quicktellerClientId, String quicktellerClientSecret, String terminalId) throws Exception {

        Utils utils = new Utils();
        long timestamp = utils.getCurrentTime();
        String nonce = utils.nonce();

        String signature = utils.signature(quicktellerClientId, quicktellerClientSecret, signatureMethod, url, timestamp, nonce, "GET");

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(url);

        // add request header
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "InterswitchAuth " + Base64.encodeBase64String(quicktellerClientId.getBytes()));

        request.setHeader("Timestamp", "" + timestamp);
        request.setHeader("Nonce", nonce);
        request.setHeader("SignatureMethod", signatureMethod);
        request.setHeader("Signature", signature);
        request.setHeader("TerminalId", terminalId);

        HttpResponse serviceResponse = client.execute(request);

        log.log(Level.INFO, "" + serviceResponse.getStatusLine().getStatusCode());
        String resp = EntityUtils.toString(serviceResponse.getEntity());
        log.log(Level.INFO, resp);
        return resp;

    }
}
