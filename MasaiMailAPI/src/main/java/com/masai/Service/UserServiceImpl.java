package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.MailException;
import com.masai.exception.UserException;
import com.masai.model.Mail;
import com.masai.model.User;
import com.masai.repositery.MailRepo;
import com.masai.repositery.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo uRepo;
	
	@Autowired
	private MailRepo mRepo;

	@Override
	public User registerUser(User user) throws UserException {
		
		if(user==null) throw new UserException("Enter Valid User Details...!");
		
		return uRepo.save(user);
	}

	@Override
	public String loginUser(String email, String password) throws UserException {
		
		Optional<User> opt = uRepo.findById(email);
		
		if(opt.isEmpty()) throw new UserException("Enter Valid Email...!");
		
		if(opt.get().getPassword().equals(password))
			return "User Login Sucessfully....!";
		else
			throw new UserException("Enter Valid User Password...!");
	}

	@Override
	public User updateUser(User user) throws UserException {
		
		Optional<User> opt = uRepo.findById(user.getEmail());
		
		if(opt.isEmpty()) throw new UserException("This User is not exists...!");
		
		if(opt.get().getPassword().equals(user.getPassword())) {
			
			user.setReceivedMails(opt.get().getReceivedMails());
			
			user.setSentMails(opt.get().getSentMails());
			
			return uRepo.save(user);
		}else
			throw new UserException("Enter Valid User Password...!");
		}

	@Override
	public List<Mail> getAllMails(String email) throws UserException {
		
		Optional<User> opt = uRepo.findById(email);
		
		if(opt.isEmpty()) throw new UserException("This User is not exists...!");
		
		return opt.get().getReceivedMails();
	}

	@Override
	public List<Mail> getStaredMails(String email) throws UserException {
		
		Optional<User> opt = uRepo.findById(email);
		
		if(opt.isEmpty()) throw new UserException("This User is not exists...!");
		
		List<Mail> list = new ArrayList<>();
		
		for(Mail m:opt.get().getReceivedMails()) {
			if(m.isStared()) {
				list.add(m);
			}
		}
		
		return list;
	}

	@Override
	public Mail sendMail(String senderEmail, String receiverEmail, Mail mail) throws UserException, MailException {
		
		Optional<User> opt = uRepo.findById(senderEmail);
		
		if(opt.isEmpty()) throw new UserException("Enter valid Sender Email ID...!");
		
		Optional<User> opt2 = uRepo.findById(receiverEmail);
		
		if(opt2.isEmpty()) throw new UserException("Enter valid Receiver Email ID...!");
		
		mail.setStared(false);
		
		mail.setSender(opt.get());
		
		mail.setReceiver(opt2.get());
		
		opt.get().getSentMails().add(mail);
		
		opt2.get().getSentMails().add(mail);
		
		return mRepo.save(mail);
	}

	@Override
	public Mail sendStaredMail(String senderEmail, String receiverEmail, Mail mail)
			throws UserException, MailException {
		
		Optional<User> opt = uRepo.findById(senderEmail);
		
		if(opt.isEmpty()) throw new UserException("Enter valid Sender Email ID...!");
		
		Optional<User> opt2 = uRepo.findById(receiverEmail);
		
		if(opt2.isEmpty()) throw new UserException("Enter valid Receiver Email ID...!");
		
		mail.setStared(true);
		
		mail.setSender(opt.get());
		
		mail.setReceiver(opt2.get());
		
		opt.get().getSentMails().add(mail);
		
		opt2.get().getSentMails().add(mail);
		
		return mRepo.save(mail);
	}

	@Override
	public Mail deleteMail(Integer mailId) throws MailException {
		
		Optional<Mail> opt = mRepo.findById(mailId);
		
		if(opt.isEmpty()) throw new MailException("Enter valid Email ID...!");
		
		for(Mail m:opt.get().getReceiver().getReceivedMails()) {
			
			if(m.getMailId()==mailId) {
				opt.get().getReceiver().getReceivedMails().remove(m);
			}
		}
		
		for(Mail m:opt.get().getSender().getSentMails()) {
			
			if(m.getMailId()==mailId) {
				opt.get().getSender().getSentMails().remove(m);
			}
		}
		
		
		mRepo.deleteById(mailId);
		
		return opt.get();
		
	}

}
