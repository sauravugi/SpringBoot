package com.masai.access.service;

import com.masai.access.exceptions.CalenderException;
import com.masai.access.exceptions.UserException;
import com.masai.model.Calender;

public interface CalenderService {
	
	public Calender createEvent(Calender cal, String key) throws UserException, CalenderException;
	public Calender updateEvent(Calender cal, String key, Integer eid) throws UserException, CalenderException;
	public Calender deleteEvent(Integer eid, String key) throws UserException,CalenderException;
}
