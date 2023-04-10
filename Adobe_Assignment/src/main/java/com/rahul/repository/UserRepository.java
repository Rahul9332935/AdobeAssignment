package com.rahul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rahul.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	@Query("SELECT COUNT(u) FROM User u")
    public Long countAllUsers();
	
	@Query(value = "SELECT u FROM User u INNER JOIN  Post p ON u.id=p.user.id GROUP BY u.id ORDER BY COUNT(p.id) DESC LIMIT 5")
	public List<User> findTop5ActiveUsers();
}
