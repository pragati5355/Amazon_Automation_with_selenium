package com.mb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Main class
 * 
 * @author Mindbowser | rohit.kavthekar@mindbowser.com
 */
@SpringBootApplication
@PropertySource("classpath:common.properties")
@PropertySource("classpath:exception-message.properties")
@PropertySource("classpath:response-message.properties")
@PropertySource("classpath:profiles/${spring.profiles.active}/application.properties")
public class MbSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbSpringRestApplication.class, args);
	}
}