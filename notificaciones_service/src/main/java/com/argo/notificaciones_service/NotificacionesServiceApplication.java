package com.argo.notificaciones_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EntityScan({"com.commons.user.models.entity", "com.argo.notificaciones_service"})
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class NotificacionesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificacionesServiceApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
