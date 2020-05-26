package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("name-of-property") is used to read the properties from application.properties file
@ConfigurationProperties("limits-service")
public class Configuration {
	//We need to write data members of this class according to the properties we want to read from application.properties
	
	private int minimum;
	private int maximum;
	
	//We need a default no-argument constructor in order to read the values from application.properties
	public Configuration() {
		
	}
	
	//Default constructor for object creation
	public Configuration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	//We need getters and setters for this class to do it's designated work properly
	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
}
