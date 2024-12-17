package com.learn.SpringDataJPA.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.SpringDataJPA.Entities.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository("jpaDao")
@Transactional
public class UserJPARepository implements UserRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public UserEntity addUser(UserEntity user) {
		
		System.out.println("Inside addUser of jpaDao");
		entityManager.persist(user); // persist will not send the changes to db but you are using@Transactional to
										// commit the changes
		entityManager.flush(); // but still flush is required to store the generated id in the user object and
								// return it
		return user; // user id will be set if successful
	}

	@Override
	public List<UserEntity> getAllUsers() {
		// using JPQL
		TypedQuery<UserEntity> query = entityManager.createQuery("select u From UserEntity u", UserEntity.class);
		return query.getResultList();
		// using native query
		// return entitymanager.createNativeQuery("select * from
		// person",Person.class).getResultList();
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {

		UserEntity user = entityManager.find(UserEntity.class, id);
		return Optional.ofNullable(user);
	}

	@Override
	public boolean deleteUserById(int id) {

		UserEntity user = entityManager.find(UserEntity.class, id);

		if (user != null) {
			entityManager.remove(user);
			UserEntity deletedUser = entityManager.find(UserEntity.class, id);
			if (deletedUser == null) {
				return true;
			} else {
				return false;
			}
		}
		else 
		{
			return false;
		}
	}

	@Override
	public boolean deleteAllUsers() {
		try {
			Query query = entityManager.createQuery("DELETE FROM UserEntity u");
			int deletedCount = query.executeUpdate(); // Executes the delete query

			return deletedCount > 0; // Returns true if any rows were deleted
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception if needed
			return false; // Return false if there's an error
		}
	}

	@Override
	public boolean partialUpdateUser(int id, Map<String, Object> updates) {
		UserEntity user = entityManager.find(UserEntity.class, id);

	    // Check if the user exists
	    if (user != null) {
	        // Loop through the updates map and apply changes to the entity
	        updates.forEach((key, value) -> {
	            switch (key) {
	                case "firstname":
	                    user.setFirstname((String) value);
	                    break;
	                case "lastname":
	                    user.setLastname((String) value);
	                    break;
	                // You can add more fields as needed
	                default:
	                    // Handle other cases if required
	                    break;
	            }
	        });

	        // Commit the changes by flushing the persistence context
	        entityManager.flush(); // This will persist the changes to the database

	        return true; // Return true if update was successful
	    } else {
	        return false; // Return false if user is not found
	    }
	}

}
