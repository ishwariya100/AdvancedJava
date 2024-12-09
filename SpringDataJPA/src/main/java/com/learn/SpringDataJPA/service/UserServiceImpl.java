package com.learn.SpringDataJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.learn.SpringDataJPA.Entities.UserEntity;
import com.learn.SpringDataJPA.repository.UserRepository;
import com.learn.SpringDataJPA.repository.UserSpringDataJPARepository;

@Service
public class UserServiceImpl implements UserService {
	
	/*
	@Autowired
	@Qualifier("userSpringDataJPARepository")
	private UserRepository userRepository;
	*/
	
	// Spring Data JPA code 
	
	@Autowired
    private UserSpringDataJPARepository userSpringDataJpaRepository;
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		return userSpringDataJpaRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userSpringDataJpaRepository.findAll();
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {
		return userSpringDataJpaRepository.findById((long) id);
	}

	@Override
	public boolean updateUser(int id, UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/* custom query to be used for springData JPA
	@Override
	@Modifying
	@Query("UPDATE UserEntity u SET u.firstname = :firstname WHERE u.id = :id")
	int updateFirstname(@Param("id") int id, @Param("firstname") String firstname);*/
	
	
	
	
}
