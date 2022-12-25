package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Cab;
import com.masai.service.CabService;

@RestController
public class CabController {
	
	@Autowired
	private CabService cs;
	
	@PostMapping("/cab")
	public ResponseEntity<Cab> registerStudentHandler(@RequestBody Cab c) {
		
		Cab sc= cs.registerCab(c);
		return new ResponseEntity<Cab>(sc, HttpStatus.CREATED);
			
	}

}
