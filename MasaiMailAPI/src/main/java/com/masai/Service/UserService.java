package com.masai.Service;

import java.util.List;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.Mail;
import com.masai.model.User;

public interface UserService {
	
	// user API
	
	User registerUser(User user) throws UserException;
	
	String loginUser(String email,String password) throws UserException;
	
	User updateUser(User user) throws UserException;
	
	List<Mail> getAllMails(String email) throws UserException;
	
	List<Mail> getStaredMails(String email) throws UserException;
	
	// Email API
	
	Mail sendMail(String senderEmail,String receiverEmail,Mail mail)throws UserException,MailException;
	
	Mail sendStaredMail(String senderEmail,String receiverEmail,Mail mail)throws UserException,MailException;
	
	Mail deleteMail(Integer mailId)throws MailException;
	
	

}
