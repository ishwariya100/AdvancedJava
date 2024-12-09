package com.learn.SpringDataJPA.repository;

import com.learn.SpringDataJPA.Entities.UserEntity;

public interface UserRepository {
	
	Boolean saveUser(UserEntity user);
}
