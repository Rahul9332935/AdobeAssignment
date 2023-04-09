package com.rahul.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.dto.PostDTO;
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
		System.out.println(post.toString());
		User user= userService.getUserById(post.getUser().getId());
		//Post post=new Post();
		post.setUser(user);
		//post.setContent(postDto.getPostContent());
		return postRepository.save(post);
	}

	@Override
	public Post getPostById(Long postId) throws PostException {
		
		Optional<Post> op= postRepository.findById(postId);
		
		if(op.isEmpty()) throw new PostException("incorrect post id -"+postId);
		
		
		return op.get();
	}

	@Override
	public Post updatePostById(long postId, PostDTO postDto) throws PostException {
		
		Post existingPost =getPostById(postId);
		
		if(postDto.getPostContent()!=null) {
			existingPost.setContent(postDto.getPostContent());
		}
		
		
		return postRepository.save(existingPost);
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

	@Override
	public Long totalNumberOfPost() {
		
		return postRepository.countPosts();
	}

	@Override
	public List<Post> top5MostLikedPosts() {
		
		return postRepository.findTop5MostLikedPosts();
	}

}
