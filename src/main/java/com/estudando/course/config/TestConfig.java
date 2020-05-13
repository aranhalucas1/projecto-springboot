package com.estudando.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudando.course.entities.User;
import com.estudando.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Lucas Aranha", "lucas@gmail.com", "2121221", "7654321");
		User u2 = new User(null, "Renato Aranha", "renato@gmail.com", "7657575", "126347"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
