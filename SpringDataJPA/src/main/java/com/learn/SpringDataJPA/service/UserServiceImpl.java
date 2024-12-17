package com.learn.SpringDataJPA.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.learn.SpringDataJPA.Entities.UserEntity;
import com.learn.SpringDataJPA.repository.UserRepository;
import com.learn.SpringDataJPA.repository.UserSpringDataJPARepository;

@Service
public class UserServiceImpl implements UserService {
	
	// Spring Data JPA code 
	
	/*
	@Autowired
    private UserSpringDataJPARepository userSpringDataJpaRepository;
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		return userSpringDataJpaRepository.save(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userSpringDataJpaRepository.findAll();
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {
		return userSpringDataJpaRepository.findById((long) id);
	}

	@Override
	public boolean deleteUserById(int id) {
		try {
			userSpringDataJpaRepository.deleteById((long)id);
            return true; // Successfully deleted
        } catch (EmptyResultDataAccessException e) {
            return false; // User not found
        }
	}

	@Override
	public boolean deleteAllUsers() {		
		try {
			userSpringDataJpaRepository.deleteAll();
            return true; // Successfully deleted
        } catch (EmptyResultDataAccessException e) {
            return false; // User not found
        }
	}

	@Override
	public boolean partialUpdateUser(int id, Map<String, Object> updates) {
		
		Optional<UserEntity> optionalUser = userSpringDataJpaRepository.findById((long)id);
		
		if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            // 2. Update only the provided fields dynamically
            updates.forEach((key, value) -> {
                switch (key) {
                    case "firstname":
                        user.setFirstname((String)value);
                        break;
                    case "lastname":
                        user.setLastname((String)value);
                        break;
                    default:
                        throw new IllegalArgumentException("Field " + key + " is not updatable");
                }
            });

            // 3. Save the updated user back to the database
            userSpringDataJpaRepository.save(user);

            return true; // Update successful
        } else {
            return false; // User not found
        }
	}
	*/
	
	@Autowired
	/*@Qualifier("jdbcDao")*/
	@Qualifier("jpaDao")
	private UserRepository userRepository;
	
	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.addUser(user);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {
		return userRepository.getUserById(id);
	}
	
	/*
	@Override
	public boolean updateUser(int id, UserEntity user) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public boolean deleteUserById(int id) {
		return userRepository.deleteUserById(id);
	}

	@Override
	public boolean deleteAllUsers() {		
		return userRepository.deleteAllUsers();
	}

	@Override
	public boolean partialUpdateUser(int id, Map<String, Object> updates) {
		return userRepository.partialUpdateUser(id, updates);
	}

}
