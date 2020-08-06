package com.maincoders.cakefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CakeFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeFactoryApplication.class, args);
	}

}
