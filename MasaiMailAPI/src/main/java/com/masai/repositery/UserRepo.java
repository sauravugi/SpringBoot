package com.masai.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.User;

public interface UserRepo extends JpaRepository<User, String> {

}
