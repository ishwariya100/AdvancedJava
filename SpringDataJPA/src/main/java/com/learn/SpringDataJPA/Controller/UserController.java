package com.learn.SpringDataJPA.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.SpringDataJPA.Entities.UserEntity;
import com.learn.SpringDataJPA.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	UserService userServiceObject;
	
	@PostMapping(value="/add")
	public  UserEntity insertUser(@RequestBody UserEntity user) {	
		return userServiceObject.saveUser(user); 
	}
	
	@GetMapping(value="/getAllUsers")
	public List<UserEntity> getAllUsers(){
		return userServiceObject.getAllUsers();
	}
	
	@GetMapping(value="/getUserById/{id}")
	public Optional<UserEntity> getUserById(@PathVariable int id){
		System.out.println("The id received is "+ id);
		return userServiceObject.getUserById(id);
	}
	
	/*
	@PatchMapping(value="/update/{id}")
	public UserEntity updateUser(@PathVariable int id, @RequestBody UserEntity user) {
		
	}
	*/

}
