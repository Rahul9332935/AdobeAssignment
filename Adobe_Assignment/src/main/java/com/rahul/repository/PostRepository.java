package com.rahul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
