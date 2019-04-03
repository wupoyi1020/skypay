package com.example.skypay.service;

import com.fasterxml.jackson.databind.JsonNode;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class ErrorService {
    public void callerNameError(Exchange exchange) {
        String callerName = exchange.getIn().getHeader("callerName", String.class);
        exchange.getOut().setBody("Caller Name [" + callerName + "] Is Not Acceptable");
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 406);
    }

    public void actionError(Exchange exchange) {
        JsonNode body = (JsonNode) exchange.getIn().getBody();
        exchange.getOut().setBody("Action [" + body.get("action") + "] Is Not Acceptable");
        exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, 406);
    }
}