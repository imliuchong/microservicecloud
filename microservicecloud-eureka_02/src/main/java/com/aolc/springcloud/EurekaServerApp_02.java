package com.aolc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: L.C
 * @Date: 2019-07-02 22:54
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp_02 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp_02.class, args);
    }

}
