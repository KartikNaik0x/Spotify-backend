package com.kartik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateway.class,args);
        System.out.println("Hello world!");
    }
}