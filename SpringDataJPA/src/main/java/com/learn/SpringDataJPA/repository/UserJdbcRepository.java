package com.learn.SpringDataJPA.repository;

import org.springframework.stereotype.Repository;

import com.learn.SpringDataJPA.Entities.UserEntity;

@Repository("jdbcRepository")
public class UserJdbcRepository implements UserRepository {

	@Override
	public Boolean saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

}
