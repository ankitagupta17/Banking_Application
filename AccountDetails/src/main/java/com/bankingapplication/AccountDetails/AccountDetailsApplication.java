package com.bankingapplication.AccountDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDetailsApplication.class, args);
	}

}

