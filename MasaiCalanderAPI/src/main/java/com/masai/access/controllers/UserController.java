package com.masai.access.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.access.exceptions.CalenderException;
import com.masai.access.exceptions.LoginException;
import com.masai.access.exceptions.UserException;
import com.masai.access.models.UserDto;
import com.masai.access.service.UserService;
import com.masai.model.Calender;
import com.masai.model.User;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/masaicalender")
public class UserController {

	@Autowired
	private UserService userService;


	@PostMapping("/register")
	public ResponseEntity<User> registerUserHandler(@Valid @RequestBody User user) throws UserException {

		User savedUser = userService.saveUser(user);

		return new ResponseEntity<User>(savedUser, HttpStatus.OK);

	}
	
	

	@PutMapping("/user")
	public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user, @RequestParam("key") String key)
			throws UserException, LoginException {

		User updatedUser = userService.updateUser(user, key);

		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}


	@PostMapping("/login")
	public ResponseEntity<String> loginUserHandler( @RequestBody UserDto user) throws LoginException {

		String res = userService.loginUser(user);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	

	@PostMapping("/logout")
	public ResponseEntity<String> logoutUserHandler(@RequestParam("key") String key) throws LoginException {

		String res = userService.logoutUser(key);

		return new ResponseEntity<String>(res, HttpStatus.OK);

	}
	
	@GetMapping("/event/{type}")
	public ResponseEntity<List<Calender>> getEventWithTypes(@RequestParam String type) throws CalenderException{
		List<Calender> list =  userService.getEventWithType(type);
		
		return new ResponseEntity<List<Calender>>(list,HttpStatus.OK);
	}
	
	

}
