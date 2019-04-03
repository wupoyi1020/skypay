package com.example.skypay;

import com.example.skypay.service.ErrorService;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class SkyPayRouteBuilder extends RouteBuilder {

        @Override
        public void configure() throws Exception {
                restConfiguration().component("restlet").host("0.0.0.0").port("8080").bindingMode(RestBindingMode.auto);

                rest("/v1/services").get("container").enableCORS(true)
                        .route().transform().spel("#{T(org.apache.camel.util.InetAddressUtil).getLocalHostName()}");

                rest("/v1/services").post("{callerName}").enableCORS(true).route()
                        .choice()
                        .when(header("callerName").in("owenwu"))
                        .to("direct:filtered")
                        .otherwise().bean(ErrorService.class, "callerNameError");

                from("direct:filtered")
                        .choice()
                        .when().simple("${body['action']} == 'payoutQueue'").to("direct:payoutQueue")
                        .when().simple("${body['action']} == 'payoutQueuePayout'").to("direct:payoutQueuePayout")
                        .when().simple("${body['action']} == 'cancelPayout'").to("direct:cancelPayout")
                        .when().simple("${body['action']} == 'payoutInquiry'").to("direct:payoutInquiry")
                        .when().simple("${body['action']} == 'payoutPayout'").to("direct:payoutPayout")
                        .when().simple("${body['action']} == 'collectionInquiry'").to("direct:collectionInquiry")
                        .when().simple("${body['action']} == 'collectionCollect'").to("direct:collectionCollect")
                        .when().simple("${body['action']} == 'balanceQuery'").to("direct:balanceQuery")
                        .otherwise().bean(ErrorService.class, "actionError")
                        .end();

                // from("direct:payoutQueue").transform().simple("${body}");
                from("direct:payoutQueuePayout").transform().simple("${body}");
                from("direct:cancelPayout").transform().simple("${body}");
                from("direct:payoutInquiry").transform().simple("${body}");
                from("direct:payoutPayout").transform().simple("${body}");
                from("direct:collectionInquiry").transform().simple("${body}");
                from("direct:collectionCollect").transform().simple("${body}");
                from("direct:balanceQuery").transform().simple("${body}");
        }
}