package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.Mail;
import com.masai.model.User;
import com.masai.Service.UserService;

@RestController("/masaiMail")
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
	
	@GetMapping("/mail/{email}")
	public ResponseEntity<List<Mail>> getAllMailHandler(@PathVariable String email) throws UserException{
		
		List<Mail> list = uService.getAllMails(email);
		
		return new ResponseEntity<List<Mail>>(list , HttpStatus.OK);
		
	}
	
	@GetMapping("/starred/{email}")
	public ResponseEntity<List<Mail>> getCommentsByBlogHandler(@PathVariable String email) throws UserException,MailException{
		
		List<Mail> list = uService.getStaredMails(email);
		
		return new ResponseEntity<List<Mail>>(list , HttpStatus.OK);
		
	}


	
	@PostMapping("/mail")
	public ResponseEntity<Mail> sendMailHandler(@Valid @RequestBody String sender,String receiver,Mail mail) throws UserException, MailException{
		
			Mail email = uService.sendMail(sender, receiver, mail);
			
			return new ResponseEntity<Mail>(email, HttpStatus.OK);
	}
	
	@PostMapping("/starredMail")
	public ResponseEntity<Mail> sendStarredHandler(@Valid @RequestBody String sender,String receiver,Mail mail) throws UserException, MailException{
		
			Mail email = uService.sendStaredMail(sender, receiver, mail);
			
			return new ResponseEntity<Mail>(email, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/mail/{id}")
	public ResponseEntity<Mail> deleteCommentById(@PathVariable Integer id) throws UserException, MailException{
		
		Mail email = uService.deleteMail(id);
		
		return new ResponseEntity<Mail>(email , HttpStatus.OK);
		
	}

}
