package com.masai.access.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.masai.access.dao.CurrentUserSessionRepo;
import com.masai.access.dao.UserRepo;
import com.masai.access.exceptions.CalenderException;
import com.masai.access.exceptions.LoginException;
import com.masai.access.exceptions.UserException;
import com.masai.access.models.CurrentUserSession;
import com.masai.access.models.UserDto;
import com.masai.model.Calender;
import com.masai.model.User;
import com.masai.repositery.CalenderRepo;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

//	62P2rH	

	@Autowired
	private UserRepo uRepo;

	@Autowired
	private CurrentUserSessionRepo csdao;
	
	@Autowired
	private CalenderRepo crepo;


	@Override
	public User saveUser(User user) throws UserException {

		User existingUserName = uRepo.findByUserName(user.getUserName());
		User existingUserEmail = uRepo.findByEmail(user.getEmail());

		if (existingUserName != null)
			throw new UserException("Username already exists " + user.getUserName());
		
		if (existingUserEmail != null)
			throw new UserException("User email exists " + user.getEmail());
//          user.setMail(user.getMail());
       
		return uRepo.save(user);
	}

	@Override
	public User updateUser(User user, String key) throws UserException, LoginException {

		CurrentUserSession loggedInUser = csdao.findByUuid(key);

		if (loggedInUser == null) {
			throw new UserException("Please provide a valid key to update a customer");
		}

		if (user.getUserLoginId() == loggedInUser.getUserId()) {
			return uRepo.save(user);
		} else
			throw new LoginException("Invalid User Details, please login first");

	}

	

	@Override
	public String loginUser(UserDto user) throws LoginException {

		User existingUser = uRepo.findByUserName(user.getUserName());

		if (existingUser == null)
			throw new LoginException("Invalid credentials. Username does not exist " + user.getUserName());

		Optional<CurrentUserSession> validCustomerSessionOpt = csdao.findById(existingUser.getUserLoginId());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this username");

		}

		if (existingUser.getPassword().equals(user.getPassword())) {

			String key = RandomString.make(6);
			
			Boolean isAdmin = false;

			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserLoginId(), key, isAdmin,
					LocalDateTime.now());

			csdao.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logoutUser(String key) throws LoginException {

		CurrentUserSession validCustomerSession = csdao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this username");

		}

		csdao.delete(validCustomerSession);

		return "Logged Out !";
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<Calender> getEventWithType(String eventType) throws CalenderException {
		
		List<Calender> calList =  crepo.findAll();
		
		List<Calender> list = new ArrayList<>();
		if(eventType.equals("month")) {
			for(Calender k : calList) {
				SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
//				String date1 = sdfo.format(k.getFromDate());
//				String date2 = sdfo.format(k.getToDate());
//				System.out.println("hello");
//				System.out.println(k.getFromDate().getMonthValue()+" "+ LocalDate.now().getMonthValue());
				if(k.getFromDate().getMonthValue() ==LocalDate.now().getMonthValue() &&k.getToDate().getMonthValue()==LocalDate.now().getMonthValue()){
					{
						
						
						list.add(k);
				}
					
				}
			}
			return list;
		}
		if(eventType.equals("week")) {
			for(Calender k : calList) {
				SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
//				String date1 = sdfo.format(k.getFromDate());
//				String date2 = sdfo.format(k.getToDate());
//				System.out.println("hello");
//				System.out.println(k.getFromDate().getDayOfWeek()+" "+ LocalDate.now().getDayOfWeek());
				
				LocalDate today = LocalDate.now();
//				LocalDate weekToday = today.wee
				LocalDate weekNext = today.plusWeeks(1);
				
//				System.out.println(today);
//				System.out.println(weekNext);
//				System.out.println(k);
//				System.out.println(k.getFromDate()+" "+(weekNext.getDayOfMonth()));
//				System.out.println(k.getFromDate().getDayOfMonth()>=today.getDayOfMonth());
//				System.out.println(k.getToDate().getDayOfMonth()+" "+weekNext.getDayOfMonth());
//				System.out.println(k.getToDate().getDayOfMonth()<=weekNext.getDayOfMonth());
				if(k.getFromDate().getDayOfMonth()>=today.getDayOfMonth() && k.getToDate().getDayOfMonth()<weekNext.getDayOfMonth() && k.getFromDate().getMonthValue()==today.getMonthValue()&& k.getToDate().getMonthValue()==today.getMonthValue()){
					{
						
						
						list.add(k);
				}
					
				}
			}
			return list;
		}
		if(eventType.equals("day")) {
			for(Calender k : calList) {
				SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
//				String date1 = sdfo.format(k.getFromDate());
//				String date2 = sdfo.format(k.getToDate());
//				System.out.println("hello");
//				System.out.println(k.getFromDate().equals(LocalDate.now()));
				if(k.getFromDate().equals(LocalDate.now())&& k.getToDate().equals(LocalDate.now())){
					{
						
						list.add(k);
				}
					
				}
			}
			return list;
		}
	
		else {
			List<Calender> allEvents =  crepo.findByEventType(eventType);
			return allEvents;
		}
		 
		 
	}

}
