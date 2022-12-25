package com.masai.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Pattern(regexp = "^[a-zA-Z]{3,20}", message = "length must be >=3")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]{3,20}", message = "length must be >=3")
	private String lastName;
	
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message ="Mobile number must be 10 digits")
	private String phoneNumber;
	
	@Past
	private LocalDate dateOfBirth;
	
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{6,12}$", message = "length must be >=6 and less 13")
	private String password;
	
	private String role ="user";
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	List<Event> events;

	

}
