package com.rahul.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.exception.PostException;
import com.rahul.exception.UserNotFoundException;
import com.rahul.model.Post;
import com.rahul.model.User;
import com.rahul.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Post createPost(Post post) throws UserNotFoundException {
		
		/*
		here getting user if useid is correct then getUserById is not gonna throw exception
		 else it throw exception and stop the program.
		*/
		User user= userService.getUserById(post.getUser().getId());
		
		return postRepository.save(post);
	}

	@Override
	public Post getPostById(Long postId) throws PostException {
		
		Optional<Post> op= postRepository.findById(postId);
		
		if(op.isEmpty()) throw new PostException("incorrect post id -"+postId);
		
		
		return op.get();
	}

	@Override
	public Post updatePostById(long postId, Post post) throws PostException {
		
		Post updatedPost =getPostById(postId);
		
		if(post.getTitle()!=null) {
			updatedPost.setTitle(post.getTitle());
		}
		if(post.getContent()!=null) {
			updatedPost.setContent(post.getContent());
		}
		
		
		return postRepository.save(post);
	}

	@Override
	public String deletePostById(Long postId) throws PostException {
		Post post =getPostById(postId);
		
		postRepository.delete(post);
		
		return "post got deleted";
	}

	@Override
	public Post likePost(Long postId) throws PostException {
		
		Post post= getPostById(postId);
		
		post.setLikes(post.getLikes()+1);
		
		return postRepository.save(post);
	}

	@Override
	public Post unlikePost(Long postId) throws PostException {
		Post post= getPostById(postId);
		
		if(post.getLikes() ==0) {
			throw new PostException("post like is 0");
		}
		
		post.setLikes(post.getLikes()-1);
		
		return postRepository.save(post);
	}

}
