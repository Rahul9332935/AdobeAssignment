package com.rahul.service;
import java.util.List;

import com.rahul.dto.PostDTO;
import com.rahul.exception.PostException;
import com.rahul.exception.UserNotFoundException;
import com.rahul.model.Post;


public interface PostService {

	public Post createPost(Post post) throws UserNotFoundException;
	
	public Post  getPostById(Long postId) throws PostException;
	
	public Post updatePostById(long postId, PostDTO postDto) throws PostException;
	
	public String deletePostById(Long postId) throws PostException;
	
	public Post likePost(Long postId) throws PostException;
	
	public Post unlikePost(Long postId) throws PostException;
	
	public List<Post> getAllPost();
	
	public Long totalNumberOfPost();
	
	public List<Post> top5MostLikedPosts();
}
