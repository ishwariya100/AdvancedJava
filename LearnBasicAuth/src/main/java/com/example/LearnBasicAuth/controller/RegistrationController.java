package com.example.LearnBasicAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearnBasicAuth.Dto.UserDto;
import com.example.LearnBasicAuth.Exception.DatabaseSaveException;
import com.example.LearnBasicAuth.service.RegistrationService;

@RestController
//@RequestMapping("/rest/user/")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/rest/user/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) throws Exception {
		System.out.println("iNSIDE REGISTER USER");
		try {
		registrationService.registerUser(userDto);
		return ResponseEntity.ok("User registered successfully");
		}
		catch(DatabaseSaveException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}
	}
	
	@GetMapping("rest/api/get")
	public String get() {
		return "SpringBoot";
	}
	
	@GetMapping("/api/getByAdmin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getByAdmin() {
		return "SpringBoot- Admin";
	}
	
	@GetMapping("/api/getByUser")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getByUser() {
		return "SpringBoot - User";
	}
	

}
