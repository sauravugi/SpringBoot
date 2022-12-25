package com.masai.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Mail;

public interface MailRepo extends JpaRepository<Mail, Integer> {

}
