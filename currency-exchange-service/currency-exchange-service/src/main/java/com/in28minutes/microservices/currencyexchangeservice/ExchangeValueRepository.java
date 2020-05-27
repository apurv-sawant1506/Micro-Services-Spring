package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

//To create custom method for database queries using JPA, we need to create an Interface which extends JpaRepository interface
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	//Here we just define the method
	//Spring JPA - Hibernate will provide us with the implementation.
	ExchangeValue findByFromAndTo(String from, String to);
}
