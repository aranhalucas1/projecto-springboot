package com.estudando.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudando.course.entities.User;

@RestController //para dizer que essa classe é um recurso web implementado por um controlador rest
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "maria", "maria@gmail.com", "3123124", "12345");
		return ResponseEntity.ok().body(u);
	}
}
