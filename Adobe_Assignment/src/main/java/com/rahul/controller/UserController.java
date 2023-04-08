package com.rahul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.exception.UserNotFoundException;
import com.rahul.model.User;
import com.rahul.service.UserService;

import jakarta.validation.Valid;

@RestController

public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> createUserHandler(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable Long userId) throws UserNotFoundException {
		
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}

	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUserByIdHandler(@PathVariable Long userId, @RequestBody User user) throws UserNotFoundException {
		
		return new ResponseEntity<User>(userService.updateUserById(userId, user), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable Long userId) throws UserNotFoundException {
		
		return new ResponseEntity<String>(userService.deleteUserById(userId), HttpStatus.OK);	}

	@GetMapping("/analytics/users")
	public ResponseEntity<Long> getTotalNumberOfUserHandler() {
		
		return new ResponseEntity<Long>(userService.getTotalNumberOfUser(), HttpStatus.OK);
	}

	 @GetMapping("/analytics/users/top-active")
	public ResponseEntity<List<User>> getTopActiveUsersHandler() {
		
		return new ResponseEntity<List<User>>(userService.getTopActiveUsers(), HttpStatus.OK);
	}

}
