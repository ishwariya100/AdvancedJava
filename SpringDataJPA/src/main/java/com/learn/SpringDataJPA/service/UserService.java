package com.learn.SpringDataJPA.service;

import java.util.List;
import java.util.Optional;

import com.learn.SpringDataJPA.Entities.UserEntity;

public interface UserService {
	
	public UserEntity saveUser(UserEntity user);
	
	public List<UserEntity> getAllUsers();

	public Optional<UserEntity> getUserById(int id);
	
	public boolean updateUser(int id, UserEntity user);

}
