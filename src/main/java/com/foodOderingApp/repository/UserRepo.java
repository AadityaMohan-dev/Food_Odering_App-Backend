package com.foodOderingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodOderingApp.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	@Query("select u from User u where u.username=?1")
	User findByUsername(String username);

	@Query("select u from User u where u.id=?1")
	User getUserByuserId(Long id);

}
