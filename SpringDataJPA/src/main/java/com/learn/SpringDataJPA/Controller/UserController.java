package com.learn.SpringDataJPA.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	
	@PatchMapping(value="/update/{id}")
	public ResponseEntity<String> updateUserPartially(@PathVariable int id, @RequestBody Map<String, Object> updates) {
		boolean isUpdated = userServiceObject.partialUpdateUser(id, updates);
		if (isUpdated) {
            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
	}
	
	
	@DeleteMapping(value="deleteById/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		boolean isDeleted = userServiceObject.deleteUserById(id);
		if(isDeleted) {
			return ResponseEntity.ok("user Successfully deleted");
		}
		else {
			return ResponseEntity.status(404).body("user not found");
		}
	}
	
	@DeleteMapping(value="deleteAll")
	public ResponseEntity<String> deleteAllUsers(){
		boolean isDeleted = userServiceObject.deleteAllUsers();
		if(isDeleted) {
			return ResponseEntity.ok("users Successfully deleted");
		}
		else {
			return ResponseEntity.status(404).body("user not found");
		}
	}

}
