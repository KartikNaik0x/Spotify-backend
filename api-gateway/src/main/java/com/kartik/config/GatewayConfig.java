package com.kartik.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.server.ServerWebExchange;

import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;

/**
 * @author {2095949}
 * @Date {11-12-2023}
 */
@Configuration
public class GatewayConfig {
    @Bean
    public GlobalFilter customGlobalFilter(){
        return new CustomGlobalFilter();
    }


}
