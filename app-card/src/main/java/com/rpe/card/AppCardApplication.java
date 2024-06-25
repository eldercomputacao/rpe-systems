package com.rpe.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppCardApplication.class, args);
    }

}
