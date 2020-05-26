package com.in28minutes.microservices.limitsservice;

public class LimitConfiguration {
	private int minimum;
	private int maximum;
	
	//Default no argument constructor
	public LimitConfiguration() {
		
	}
	
	
	//General purpose constructor for creating objects
	public LimitConfiguration(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	//Getters and Setter (required)
	
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
