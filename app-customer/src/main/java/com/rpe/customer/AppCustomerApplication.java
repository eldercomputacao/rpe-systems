package com.rpe.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCustomerApplication.class, args);
	}

}
