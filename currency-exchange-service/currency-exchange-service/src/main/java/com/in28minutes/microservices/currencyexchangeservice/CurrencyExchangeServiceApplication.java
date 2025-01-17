package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
 * To run this application in many port configurations:
 * Right click on currency-exchange-service master folder
 * run->run configurations
 * Duplicate the CurrencyExchangeServiceApplication
 * 
 * In the arguments section, go to VM arguments
 * Type -> -Dserver.port=8001
 * */


@SpringBootApplication
//@EnableEurekaClient is used to let this application register itself with eureka naming server
@EnableEurekaClient
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
