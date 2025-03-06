package com.example.LearnBasicAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearnBasicAuth.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByUsername(String username);

	User findByUsername(String username);
	
}
