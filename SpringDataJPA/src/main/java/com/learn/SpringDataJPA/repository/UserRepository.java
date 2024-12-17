package com.learn.SpringDataJPA.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.learn.SpringDataJPA.Entities.UserEntity;

public interface UserRepository {
	
	public UserEntity addUser(UserEntity user);
	
	public List<UserEntity> getAllUsers();
	
	public Optional<UserEntity> getUserById(int id);
	
	public boolean deleteUserById(int id);
	
	public boolean deleteAllUsers();
	
	public boolean partialUpdateUser(int id, Map<String, Object> updates);
	
	//public boolean updateUser(int id, Map<String, Object> updates);
	
}
