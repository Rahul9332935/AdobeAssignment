package com.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.exception.UserNotFoundException;
import com.rahul.model.User;
import com.rahul.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
		
	}

	@Override
	public User getUserById(Long userId) throws UserNotFoundException {
		
		Optional<User> op =userRepository.findById(userId);
		
		if(op.isEmpty()) throw new UserNotFoundException("invalid user id - "+userId);
		
		return op.get();
	}

	@Override
	public User updateUserById(Long userId, User user) throws UserNotFoundException {
		User updatedUser= getUserById(userId);
		
		if(user.getName()!=null) {
			updatedUser.setName(user.getName());
		}
		if(user.getEmail()!=null) {
			updatedUser.setEmail(user.getEmail());
		}
		if(user.getBio()!=null) {
			updatedUser.setBio(user.getBio());
		}
		
		userRepository.save(updatedUser);
		return updatedUser;
		
	}

	@Override
	public String deleteUserById(Long userId) throws UserNotFoundException {
		User user= getUserById(userId);
		userRepository.delete(user);
		return "user "+user.toString()+" is deleeted";
	}

	@Override
	public Long getTotalNumberOfUser() {
		
		return userRepository.countAllUsers();
	}

	@Override
	public List<User> getTopActiveUsers() {
		
		return userRepository.findTop5ActiveUsers();
	}

}
