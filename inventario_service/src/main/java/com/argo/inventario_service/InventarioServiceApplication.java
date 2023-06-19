package com.argo.inventario_service;


import com.argo.inventario_service.producto.domain.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * The type Inventario service application.
 */
@EntityScan({"com.commons.user.models.entity", "com.argo.inventario_service"})
@EnableFeignClients
@EnableEurekaClient
@EnableAsync
@EnableScheduling
@EnableDiscoveryClient
@SpringBootApplication
public class InventarioServiceApplication implements CommandLineRunner {


    @Autowired
    private IProduct iProduct;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(InventarioServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }

    /**
     * Thread pool task executor executor.
     *
     * @return the executor
     */
    @Bean(name = "poolnotification")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        return threadPoolTaskExecutor;
    }

}
