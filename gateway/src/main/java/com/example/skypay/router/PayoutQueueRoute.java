package com.example.skypay.router;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PayoutQueueRoute extends RouteBuilder {
        @Override
        public void configure() throws Exception {
                from("direct:payoutQueue").setBody(constant(null)).removeHeaders("CamelHttp*").hystrix()
                        .hystrixConfiguration().executionTimeoutInMilliseconds(5000)
                        .circuitBreakerSleepWindowInMilliseconds(10000).end()
                        .setHeader("Content-Type", constant("application/json"))
                        .setHeader("Accept", constant("application/json"))
                        .setHeader(Exchange.HTTP_METHOD, constant("GET")).removeHeaders("CamelHttp*")
                        .to("https4://hacker-news.firebaseio.com/v0/maxitem.json").convertBodyTo(String.class)
                        .endRest();
        }
}