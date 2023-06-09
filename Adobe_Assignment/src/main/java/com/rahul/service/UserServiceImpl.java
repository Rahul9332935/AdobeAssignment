package com.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dto.UserDTO;
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
	public User updateUserById(Long userId, UserDTO userDto) throws UserNotFoundException {
		User updatedUser= getUserById(userId);
		
		if(userDto.getUserName()!=null && userDto.getUserName().length()!=0) {
			updatedUser.setName(userDto.getUserName());
		}
		if(userDto.getUserEmail()!=null && userDto.getUserEmail().length()!=0 ) {
			updatedUser.setEmail(userDto.getUserEmail());
		}
		if(userDto.getUserBio()!=null && userDto.getUserBio().length()!=0) {
			updatedUser.setBio(userDto.getUserBio());
		}
		
		
		return userRepository.save(updatedUser);
		
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

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

}
