package com.rahul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rahul.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("SELECT COUNT(p) FROM Post p")
	public long countPosts();

	@Query("SELECT p FROM Post p WHERE p.likes >0 ORDER BY p.likes DESC LIMIT 5")
	List<Post> findTop5MostLikedPosts();

	
}
