package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	//Primary Key
	@Id
	private Long id;
	
	//Since from is a keyword in SQl, we cannot name a column as 'from'
	//Hence we must change the column name
	//@Column(name="name_of_column_in_database") is used to specify the column name to which this column will map to
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	
	private int port;
	
	//Default no-argument constructor
	public ExchangeValue() {
		super();
	}

	//Constructor to create an object with passed parameters
	//Port is not added here in constructor because we will assign a value to it later, not during object creation.
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
