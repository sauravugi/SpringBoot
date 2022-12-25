package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;

}
