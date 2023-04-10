package com.rahul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.dto.UserDTO;
import com.rahul.exception.UserNotFoundException;
import com.rahul.model.User;
import com.rahul.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
//(origins = "http://127.0.0.1:5500")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*
	{
    "name":"Rahul",
    "email":"rahul123@gmail.com",
    "bio":"java backend devloper"
	}
	 */
	
	
	@PostMapping
	public ResponseEntity<User> createUserHandler(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable Long userId) throws UserNotFoundException {
		
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}

	/*
	 {
    "userName":null,
    "userEmail":null,
    "userBio":"crypto trader"
	}
	here we pass Dto class for updating user data.
	 */
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserByIdHandler(@PathVariable Long userId, @RequestBody UserDTO userDto) throws UserNotFoundException {
		
		return new ResponseEntity<User>(userService.updateUserById(userId, userDto), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable Long userId) throws UserNotFoundException {
		
		return new ResponseEntity<String>(userService.deleteUserById(userId), HttpStatus.OK);	
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsersHandler(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

}
