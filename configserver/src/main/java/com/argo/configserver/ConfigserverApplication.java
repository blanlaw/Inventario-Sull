package com.argo.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * The type Configserver application.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigserverApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class, args);
    }


}
