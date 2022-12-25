package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mail {
	
	@Id
	private Integer mailId;
	
	private String message;
	
	private boolean stared;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User sender;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User receiver;
	
	
	

}
