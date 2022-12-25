package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Cab;
import com.masai.repo.CabRepo;

@Service
public class CabServiceImpl implements CabService {
	
	@Autowired
	private CabRepo cRepo;

	@Override
	public Cab registerCab(Cab c) {
		
		Cab c1 = cRepo.save(c) ;
		
		return c1;
	}

}
