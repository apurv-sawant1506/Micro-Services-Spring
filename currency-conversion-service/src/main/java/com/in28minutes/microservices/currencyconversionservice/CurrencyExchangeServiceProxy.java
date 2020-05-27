package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//In order to easily communicate with other micro-services, we use @FeignClient and create it's interface
//@FeignClient annotation takes two arguments:
//First-> name of the service with which we want to communicate
//Second-> url of the service with which we want to communicate
//@FeignClient(name="currency-exchange-service" , url="localhost:8000")

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
/* Ribbon is a load balancing service. It works properly with Feign Client
 * To tell Ribbon which instances of currency-exchange-service we want it to balance the load, we specify it in application.properties
 */