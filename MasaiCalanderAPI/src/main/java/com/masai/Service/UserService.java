package com.masai.Service;

import java.time.LocalDate;
import java.util.List;

import com.masai.exception.EventException;
import com.masai.exception.UserException;
import com.masai.models.Event;
import com.masai.models.User;

public interface UserService {
	
	// user API
	
	User registerUser(User user) throws UserException;
	
	String loginUser(String phone,String password) throws UserException;
	
	User updateUser(User user) throws UserException;
	
	List<Event> getAllEvents(Integer id , String startdate,String enddate) throws UserException;
	
	Event setEvent(Integer id ,Event event) throws UserException,EventException;
	
	Event updateEvent(Integer id ,Event event) throws UserException,EventException;
	
	Event deleteEvent(Integer id ,Integer event) throws UserException,EventException;
	
	

}
