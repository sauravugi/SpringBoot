package com.masai.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.models.Employee;
import com.masai.repository.EmployeeRepo;

@Service
public class CustomUser implements UserDetailsService{
	
	@Autowired
	private EmployeeRepo eRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = eRepo.findByEmail(username);
		if(emp==null) throw new UsernameNotFoundException("User Does not exist");
		return new SecurityUser(emp);
	}

}
