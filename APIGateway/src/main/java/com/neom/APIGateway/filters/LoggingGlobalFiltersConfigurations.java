package com.neom.APIGateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class LoggingGlobalFiltersConfigurations {

    final Logger logger =
            LoggerFactory.getLogger(
                    LoggingGlobalFiltersConfigurations.class);

    @Bean
    @Order(-1)
    public GlobalFilter preGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        logger.info("Global Pre Filter executed");
                        logger.info("Request uri : " +exchange.getRequest().getPath().value()
                                +" Hostname: " + exchange.getRequest().getHeaders().getHost().getHostName());


                    }));
        };
    }


    @Bean
    @Order(-2)
    public GlobalFilter resFilter(){
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    logger.info("Global Post Filter executed");

                    org.springframework.http.server.reactive.ServerHttpResponse response = exchange.getResponse();
                    logger.info("Response code from the service ==> {}", response.getStatusCode());
                    response.setRawStatusCode(201);
                    exchange.mutate().response(response).build();

                    logger.info("Modified Response code from the service ==> {}", response.getStatusCode());
                }));
    }
}