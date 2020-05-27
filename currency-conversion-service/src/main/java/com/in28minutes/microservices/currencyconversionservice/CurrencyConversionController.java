package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	//Hard-coded return values:
	/*
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		return new CurrencyConversionBean(1L, from, to , BigDecimal.valueOf(65), quantity,quantity ,0 );
	}
	*/
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		//In the getForEntity method below, we need to pass in a mapping for the URL variables.
		//To do so, we create a HashMap and pass it as an argument.
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("from" , from);
		uriVariables.put("to" , to);
		
		//To get response from Currency-Exchange-Service
		//We always collect the responses in ResponseEntity Objects
		ResponseEntity<CurrencyConversionBean> responseEntity = new  RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}" , CurrencyConversionBean.class , uriVariables);
		
		CurrencyConversionBean responseBody = responseEntity.getBody();
		
		return new CurrencyConversionBean(responseBody.getId(), from ,to ,responseBody.getConversionMultiple(), quantity , quantity.multiply(responseBody.getConversionMultiple()), responseBody.getPort());
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
			
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversionBean(response.getId(), from , to , response.getConversionMultiple() , quantity , quantity.multiply(response.getConversionMultiple()) , response.getPort());
	}
}
