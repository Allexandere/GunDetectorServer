package com.comet.serverapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAppApplication.class, args);
    }

}
