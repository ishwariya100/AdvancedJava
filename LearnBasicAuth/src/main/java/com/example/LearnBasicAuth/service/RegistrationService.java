package com.example.LearnBasicAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.LearnBasicAuth.Dto.UserDto;
import com.example.LearnBasicAuth.Entity.User;
import com.example.LearnBasicAuth.Exception.DatabaseSaveException;
import com.example.LearnBasicAuth.Repository.UserRepository;



@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public void registerUser(UserDto userDto) throws Exception {
		
		if(!userRepository.existsByUsername(userDto.getUsername())) {
			
			User user = new User();
			user.setUsername(userDto.getUsername());
			String encodedPassword = passwordEncoder.encode(userDto.getPassword());
			System.out.println("pwd is " + encodedPassword);
	        user.setPassword(encodedPassword); // setting the encoded password
			user.setEmail(userDto.getEmail());
			user.setRole(userDto.getRole());
			
			try {
				userRepository.save(user);
			}
			catch (Exception e){
				throw new DatabaseSaveException("An unexpected error occurred while saving the user: \" + e.getMessage()");
			}
			
		}
		else
		{
			throw new Exception("Username already taken");
		}
	}
	
	
}
