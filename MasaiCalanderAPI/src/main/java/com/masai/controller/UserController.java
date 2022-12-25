package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exception.UserException;
import com.masai.models.User;
import com.masai.Service.UserService;

@RestController("/masaiCalander")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user) throws UserException{
		
			User u = uService.registerUser(user);
			
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUserHandler(@RequestBody String email,String password) throws UserException{
		
		String msg = uService.loginUser(email,password);
		
		return new ResponseEntity<String>(msg , HttpStatus.ACCEPTED);
		
	}


	@PutMapping("/user")
	public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user) throws UserException{
		
			User u = uService.updateUser(user);
			
			return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	

}
