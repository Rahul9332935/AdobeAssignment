package com.rahul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.model.Post;
import com.rahul.model.User;
import com.rahul.service.PostService;
import com.rahul.service.UserService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<Long> getTotalNumberOfUserHandler() {
		
		return new ResponseEntity<Long>(userService.getTotalNumberOfUser(), HttpStatus.OK);
	}

	 @GetMapping("/users/top-active")
	public ResponseEntity<List<User>> getTopActiveUsersHandler() {
		
		return new ResponseEntity<List<User>>(userService.getTopActiveUsers(), HttpStatus.OK);
	}
	 

	@GetMapping("/posts")
	public ResponseEntity<Long> totalNumberOfPost(){ 
		return new ResponseEntity<Long>(postService.totalNumberOfPost(), HttpStatus.OK);
	}
	
	@GetMapping("/posts/top-liked")
	public ResponseEntity<List<Post>> top5MostLikedPosts(){
		return new ResponseEntity<>(postService.top5MostLikedPosts(), HttpStatus.OK);
	}
}
