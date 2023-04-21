/*
package com.neom.APIGateway.filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;

@Component
public class LoggingGlobalPreFilter  implements GlobalFilter  {

    final Logger logger =
            LoggerFactory.getLogger(LoggingGlobalPreFilter.class);

// there are two ways to use pre post filter either by implement interface global filter or by
// creating a @Bean method which returns the GlobalFilter
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            ServerHttpResponse response = exchange.getResponse();
            logger.info("Global Post Filter executed");
            logger.info("Response code from the service ==> {}", response.getStatusCode());
        }));
    }



}*/
