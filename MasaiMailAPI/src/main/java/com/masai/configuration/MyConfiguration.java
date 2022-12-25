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
	
	@Bean
	public SecurityFilterChain securityAutho(HttpSecurity http) throws Exception {
		
				http.authorizeHttpRequests(
				auth -> auth.antMatchers("/masaiMail/user","/masaiMail/mail/{email}","/masaiMail/starred/{email}").hasAuthority("user")
				.antMatchers("/masaiMail/mail","/masaiMail/starredMail","/masaiMail/mail/{id}").hasAuthority("user")
				.antMatchers("/masaiMail/register","/masaiMail/login").permitAll()
				
				).csrf().disable().httpBasic();
		
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder passwordEncode() {	
		return NoOpPasswordEncoder.getInstance();   
	}
	
	


}
