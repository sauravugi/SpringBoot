package com.masai.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EventException;
import com.masai.exception.UserException;
import com.masai.models.Event;
import com.masai.models.User;
import com.masai.repositery.EventRepo;
import com.masai.repositery.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private EventRepo eRepo;

	@Override
	public User registerUser(User user) throws UserException {
		
		if(user==null) throw new UserException("Enter Valid User Details...!");
		
		return uRepo.save(user);
	}

	@Override
	public String loginUser(String phone, String password) throws UserException {
		
		User opt = uRepo.findByPhoneNumber(phone);
		
		if(opt==null) throw new UserException("Enter Valid Phone Number...!");
		
		if(opt.getPassword().equals(password))
			return "User Login Sucessfully....!";
		else
			throw new UserException("Enter Valid User Password...!");
	}

	@Override
	public User updateUser(User user) throws UserException {
		
		Optional<User> opt = uRepo.findById(user.getId());
		
		if(opt.isEmpty()) throw new UserException("This User is not exists...!");
		
		if(opt.get().getPassword().equals(user.getPassword())) {
			
			user.setEvents(opt.get().getEvents());
			
			return uRepo.save(user);
		}else
			throw new UserException("Enter Valid User Password...!");
		}



	@Override
	public List<Event> getAllEvents(Integer id, String start, String end) throws UserException {
		List<Event> eventList = new ArrayList<>();
		
		Optional<User> opt = uRepo.findById(id);
		
		if(opt.isEmpty()) throw new UserException("This User is not exists...!");
		
		// Starting Date Change to Local date
		
		String[] str = start.split("-");
		int[] arr = new int[3];
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		LocalDate startdate = LocalDate.of(arr[0],arr[1],arr[2]);
		
		// Ending Date Change to Local date
		String[] str2 = start.split("-");
		int[] arr2 = new int[3];
		for(int i=0;i<3;i++) {
			arr[i] = Integer.parseInt(str2[i]);
		}
		LocalDate enddate = LocalDate.of(arr2[0],arr2[1],arr2[2]);
		
		for(Event e:opt.get().getEvents()) {
			if(e.getStartedDate().compareTo(startdate) >= 0 && e.getStartedDate().compareTo(enddate) <= 0) {
				eventList.add(e);
			}
		}
		
		
		return eventList;
	}


	@Override
	public Event setEvent(Integer id, Event event) throws UserException, EventException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event updateEvent(Integer id, Event event) throws UserException, EventException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event deleteEvent(Integer id, Integer event) throws UserException, EventException {
		// TODO Auto-generated method stub
		return null;
	}

}
