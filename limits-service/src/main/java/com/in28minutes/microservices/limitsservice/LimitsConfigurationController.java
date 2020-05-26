package com.in28minutes.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	//Hard-coding the return values
	/*
	@GetMapping("/limits-service")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(9,9999);
	}
	*/
	
	//We are returning an object of LimitConfiguration class which will get converted into JSON before displayed on HTML page.
	@GetMapping("limits-service")
	public LimitConfiguration retrieveLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}
}