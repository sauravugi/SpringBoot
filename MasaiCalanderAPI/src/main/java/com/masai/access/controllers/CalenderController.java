package com.masai.access.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.access.exceptions.CalenderException;
import com.masai.access.exceptions.LoginException;
import com.masai.access.exceptions.UserException;
import com.masai.access.service.CalenderService;
import com.masai.access.service.UserService;
import com.masai.model.Calender;

@RestController
@RequestMapping("/masaicalender")
public class CalenderController {
	
	@Autowired
	private CalenderService calService;

	@PostMapping("/event")
	public ResponseEntity<Calender> addEvent(@RequestBody Calender cal, @RequestParam String key) throws UserException, CalenderException{
		
		 Calender c =  calService.createEvent(cal, key);
		 
		 return new ResponseEntity<Calender>(c,HttpStatus.OK);
	}
	
	@PutMapping("/event/{id}")
	public ResponseEntity<Calender> updateEvent(@RequestBody Calender cal, @RequestParam String key, @RequestParam Integer eid) throws UserException, CalenderException{
		
		 Calender c =  calService.updateEvent(cal, key, eid);
		 
		 return new ResponseEntity<Calender>(c,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/event/{id}")
	public ResponseEntity<Calender> deleteEvent(@RequestParam String key, @RequestParam Integer eid) throws UserException, CalenderException{
		
		 Calender c =  calService.deleteEvent(eid, key);
		 
		 return new ResponseEntity<Calender>(c,HttpStatus.OK);
	}
	
	
}
