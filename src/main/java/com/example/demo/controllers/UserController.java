package com.example.demo.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Component
@Path("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("users/{id}")
	public ResponseEntity<User> getUserById(@PathParam(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users")
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
