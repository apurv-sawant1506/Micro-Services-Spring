package com.in28minutes.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

//We want spring to manage this class

//ZuulLoggingfilter is a name given by us.
//But in order to execute the Filters, it must extend the ZuulFilter abstract class and implement it's abstract methods.
@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//The following are the abstract methods of the abstract class ZuulFilter which we must implement

	@Override
	public boolean shouldFilter() {
		//Should we execute this filter or not?
		//return -> true means we want the netflix zuul API to implement this filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		//This is where all the logic is written after the calls to micro-services are intercepted
		
		//Now we would like to fetch the current http request and log it
		//We can get the current http request by RequestContext.getCurrentContext().getRequest();
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		//Now 'request' contains the intercepted request.
		//We will now log this request using logger
		
		logger.info("request -> {} request url -> {}", request, request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		//When should the filtering happen?
		
		//return "pre" -> Filtering should be done before the call goes to desired micro-service
		//return "post" -> Filtering should be done after the call is handled by the desired micro-service
		//return "error" -> Filter only the error requests.
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		//This is the priority order of the filters
		//If we have many such filters then we need to specify the priority order of these filters.
		
		return 1;
	}
	
}
