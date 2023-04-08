package com.rahul.service;
import com.rahul.exception.PostException;
import com.rahul.exception.UserNotFoundException;
import com.rahul.model.Post;


public interface PostService {

	public Post createPost(Post post) throws UserNotFoundException;
	
	public Post  getPostById(Long postId) throws PostException;
	
	public Post updatePostById(long postId, Post post) throws PostException;
	
	public String deletePostById(Long postId) throws PostException;
	
	public Post likePost(Long postId) throws PostException;
	
	public Post unlikePost(Long postId) throws PostException;
	
	
}
