package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Trip;
import com.masai.repo.TripRepo;

@Service
public class TripServiceImpl implements TripService{
	
	@Autowired
	private TripRepo tRepo;

	@Override
	public Trip registerTrip(Trip t1) {
		Trip t = tRepo.save(t1);
		
		return t;
	}

}
