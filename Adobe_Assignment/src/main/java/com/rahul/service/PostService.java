package com.rahul.service;
import com.rahul.model.Post;


public interface PostService {

	public Post createPost(Post post);
	
	public Post  getPostById(Long postId);
	
	public Post updatePostById(long postId, Post post);
	
	public String deletePostById(Long postId);
	
	public Post likePost(Long postId);
	
	public Post unlikePost(Long postId);
	
	
}
