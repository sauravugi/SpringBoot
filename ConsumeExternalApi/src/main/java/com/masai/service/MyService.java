package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.model.User;

@Service
public class MyService {
	// autowired in contructer because we register in context already
	// and with this object called getForObject method called to consume and return data
	private final RestTemplate restTemplate;
	
	@Autowired
	public MyService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	// Want to return String object in text form than simple this type used 
	public String consumeApi() {
		return restTemplate.getForObject("https://api.publicapis.org/",String.class);
	}
	
	
	// Want to return user object in json form than same field will be created in models 
	// package and setter getter and mention user defined object.class and return type 
	public User consumeApi2() {
		return restTemplate.getForObject("https://api.publicapis.org/",User.class);
	}
	
	
	
	

}
