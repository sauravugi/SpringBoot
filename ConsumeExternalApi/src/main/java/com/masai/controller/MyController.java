package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.MyService;

@RestController
public class MyController {
	
	private final MyService myService;
	
	@Autowired
	public MyController(MyService myService) {
		this.myService = myService;
	}
	
	@GetMapping("/hello")
	public String getApi() {
		return myService.consumeApi();
	}
	
	@GetMapping("/all")
	  public String allAccess() {
	    return "Public Content.";
	  }
	
	// In this Way we consume api and return in json type and maintain object
	@GetMapping("/return_user_defined_object")
	public ResponseEntity<User> getApi2(){
		return new ResponseEntity<User>(new User(),HttpStatus.ACCEPTED);
	}

}
