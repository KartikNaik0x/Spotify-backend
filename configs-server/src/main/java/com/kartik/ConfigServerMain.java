package com.kartik;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author {2095949}
 * @Date {06-12-2023}
 */

@SpringBootApplication
@EnableDiscoveryClient
//@EnableConfigServer
public class ConfigServerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain.class,args);
        System.out.println("Hello world!");
    }
}