package com.masai.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eventId;
	
	private LocalDate createdDate=LocalDate.now();
	
	@Temporal(TemporalType.DATE)
	private LocalDate startedDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Temporal(TemporalType.TIME)
	private LocalTime startedTime;
	
	@Temporal(TemporalType.TIME)
	private LocalTime endTime;
	
	private String type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	
}
