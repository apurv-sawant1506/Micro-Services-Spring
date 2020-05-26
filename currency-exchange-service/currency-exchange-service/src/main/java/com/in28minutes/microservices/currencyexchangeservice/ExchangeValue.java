package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

public class ExchangeValue {
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private int port;
	
	//Default no-argument constructor
	public ExchangeValue() {
		super();
	}

	//Constructor to create an object with passed parameters
	//Port is not added here in constructor because we will assign a value to it later, not during object creation.
	public ExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public void setPort(int port) {
		this.port=port;
	}
	
}
