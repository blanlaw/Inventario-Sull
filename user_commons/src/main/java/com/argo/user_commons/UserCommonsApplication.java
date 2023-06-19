package com.argo.user_commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EntityScan({"com.commons.user.models.entity"})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class UserCommonsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCommonsApplication.class, args);
    }

}
