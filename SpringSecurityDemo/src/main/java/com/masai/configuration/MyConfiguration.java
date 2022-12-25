package com.masai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyConfiguration {
	/*
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager();
		//employee decrepted password = 54123
		// manager decrepted password = 12345
		UserDetails manager = User.withUsername("manager").password("$2a$12$PzLv2gb52B2soJU7f2zgluy7R3yQHLtgiHZQepNig7R4A/yhD8fKS").authorities("manager").build();
		UserDetails employee = User.withUsername("employee").password("$2a$12$5swJmHOkT2HsEj6.IyHYZufpTbsmFM/uV03nqz.WTa/l9TJr3jAJy").authorities("employee").build();
		
		userDetails.createUser(employee);
		userDetails.createUser(manager);
		
		return userDetails;
	}
	
	*/
	@Bean
	public SecurityFilterChain securityAutho(HttpSecurity http) throws Exception {
		
				http.authorizeHttpRequests(
				auth -> auth.antMatchers("/get-all-reportees/{id}").hasAuthority("manager")
				.antMatchers("/get-employees-manager/{id}").hasAuthority("employee")
				.antMatchers("/get-employees/{id}").permitAll()
				
				).csrf().disable().httpBasic();
		
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncode() {
		
		return NoOpPasswordEncoder.getInstance();  // when You do not want to generate automatic dummy password
												   // which provide in InMemoryUserDetails Manager @bean method
		//return new BCryptPasswordEncoder();  // In which you want to provide encrypted password. 
	}
	
	
	
	/*
	@Bean
	public SecurityFilterChain securityChain(HttpSecurity http) throws Exception {
		
				http.authorizeHttpRequests(
				auth -> auth.antMatchers("/get-employees/{id}").authenticated()
				.antMatchers("/get-employees-manager/{id}","/get-all-reportees/{id}").permitAll()
				).httpBasic();
		
		
		return http.build();
		
	}
	
	Here only use default username password given by springBoot username is always 'user' password generate in console you have to 
	use if you authenticated() and if you permitAll() than no need to give user password it will access by all.
	This is Basic authenticated method.
	
	*/

}
