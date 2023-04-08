package com.rahul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.exception.PostException;
import com.rahul.exception.UserNotFoundException;
import com.rahul.model.Post;
import com.rahul.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController{

	@Autowired
	private PostService postService;
	
	@PostMapping
	public ResponseEntity<Post> createPostHandler(Post post) throws UserNotFoundException {
		
		return new ResponseEntity<Post>(postService.createPost(post), HttpStatus.OK);
	}

	@GetMapping("/{postId}")
	public ResponseEntity<Post> getPostByIdHandler(Long postId) throws PostException {
		
		return new ResponseEntity<Post>(postService.getPostById(postId), HttpStatus.OK);
	}

	@PutMapping("/{postId}")
	public ResponseEntity<Post> updatePostByIdHandler(long postId, Post post) throws PostException {
		
		return new ResponseEntity<Post>(postService.updatePostById(postId, post), HttpStatus.OK);
	}

	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePostByIdHandler(Long postId) throws PostException {
		
		return new ResponseEntity<String>(postService.deletePostById(postId), HttpStatus.OK);
	}

	@PostMapping("/{postId}/like")
	public ResponseEntity<Post> likePostHandler(Long postId) throws PostException {
		
		return new ResponseEntity<Post>(postService.likePost(postId), HttpStatus.OK);
	}

	@PostMapping("/{postId}/unlike")
	public ResponseEntity<Post> unlikePostHandler(Long postId) throws PostException {
		
		return new ResponseEntity<Post>(postService.unlikePost(postId), HttpStatus.OK);
	}

}