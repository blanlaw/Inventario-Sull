package com.argo.gateway;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@EntityScan({"com.commons.user.models.entity"})
@EnableZuulProxy
@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableScheduling
public class GatewayApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
