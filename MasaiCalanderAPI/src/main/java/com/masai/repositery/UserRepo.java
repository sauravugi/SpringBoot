package com.masai.repositery;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByPhoneNumber(String number);

}
