package com.learn.SpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.SpringDataJPA.Entities.UserEntity;

public interface UserSpringDataJPARepository extends JpaRepository<UserEntity, Long>{

}
