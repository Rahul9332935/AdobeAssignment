package com.rahul.service;

import java.util.List;

import com.rahul.exception.UserNotFoundException;
import com.rahul.model.User;

public interface UserService {

	
	public User createUser(User user);
	
	public User getUserById(Long userId);
	
	public User updateUserById(Long userId, User user);
	
	public User deleteUserById(Long userId) throws UserNotFoundException;
	
	public Long getTotalNumberOfUser();
	
	public List<User> getTopActiveUsers(); 
	
}
