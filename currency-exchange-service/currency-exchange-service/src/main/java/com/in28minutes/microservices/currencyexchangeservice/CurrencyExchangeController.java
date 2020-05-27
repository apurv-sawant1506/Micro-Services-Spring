package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	//The environment object contains details about the current environment configuration
	//These details can be retrieved using this object
	//Here we are using this object to retrieve the value of current port
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from , @PathVariable String to) {
//		ExchangeValue exchangeValue = new ExchangeValue(10001L , from , to , BigDecimal.valueOf(65));
		
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		
		//Setting the value of current port
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		return exchangeValue;
	}
}
