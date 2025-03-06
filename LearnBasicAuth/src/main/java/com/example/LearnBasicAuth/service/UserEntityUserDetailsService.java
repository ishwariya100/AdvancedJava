package com.example.LearnBasicAuth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.LearnBasicAuth.Entity.User;
import com.example.LearnBasicAuth.Repository.UserRepository;
import com.example.LearnBasicAuth.Security.UserToUserDetails;

@Component
public class UserEntityUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
		return user.map(UserToUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

}
