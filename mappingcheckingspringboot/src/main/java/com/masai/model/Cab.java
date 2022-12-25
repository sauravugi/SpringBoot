package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "cab")
	private Driver driver;

}
