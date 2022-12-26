package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	// RestTemplate Object register in context area 
	// It is responsible to consume data because inbuilt method here
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
