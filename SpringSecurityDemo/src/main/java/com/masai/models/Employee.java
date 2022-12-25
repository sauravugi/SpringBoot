package com.masai.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private Integer salary;
	
	@NotNull
	private String role;
	
	@Email
	private String email;
	
	private Integer managerId;

}
