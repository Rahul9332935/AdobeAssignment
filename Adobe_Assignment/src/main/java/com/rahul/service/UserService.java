package com.rahul.service;

import java.util.List;

import com.rahul.dto.UserDTO;
import com.rahul.exception.UserNotFoundException;
import com.rahul.model.User;

public interface UserService {

	
	public User createUser(User user);
	
	public User getUserById(Long userId) throws UserNotFoundException;
	
	public User updateUserById(Long userId, UserDTO userDto) throws UserNotFoundException ;
	
	public String deleteUserById(Long userId) throws UserNotFoundException;
	
	public List<User> getAllUsers();
	
	public Long getTotalNumberOfUser();
	
	public List<User> getTopActiveUsers(); 
	
}
