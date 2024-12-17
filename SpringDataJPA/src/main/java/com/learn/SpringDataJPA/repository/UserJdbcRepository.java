package com.learn.SpringDataJPA.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.learn.SpringDataJPA.Entities.UserEntity;


@Repository("jdbcDao")
public class UserJdbcRepository implements UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class UserEntityRowMapper implements RowMapper<UserEntity>{

		@Override
		public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserEntity user = new UserEntity();
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setId(rs.getInt("id"));
			return user;
		}
		
	}
	
	@Override
	public UserEntity addUser(UserEntity user) {		
		
		System.out.println("Inside addUser method ");
		String sql = "insert into user_entity(firstname, lastname) values (?,?)";
		if(jdbcTemplate.update(sql, user.getFirstname(), user.getLastname()) > 0) {			
			String query = "select * from user_entity where firstname = ? and lastname = ?";
		    UserEntity savedUser = jdbcTemplate.queryForObject(query, new UserEntityRowMapper(), user.getFirstname(), user.getLastname());		    
		    return savedUser; 
		}
		else {			
			return null;
		}
	}

	@Override
	public List<UserEntity> getAllUsers() {
		String query = "select * from user_entity";
		return jdbcTemplate.query(query, new UserEntityRowMapper());
	}

	@Override
	public Optional<UserEntity> getUserById(int id) {
		
		String query = "select * from user_entity where id=?";
		try {
			UserEntity user = jdbcTemplate.queryForObject(query, new UserEntityRowMapper(), id);
			return Optional.of(user);
		}
		catch (EmptyResultDataAccessException e){
			return Optional.empty();
		}
	}

	@Override
	public boolean deleteUserById(int id) {
		
		String sql = "delete from user_entity where id=?";
		if(jdbcTemplate.update(sql, id) > 0) {				    
		    return true; 
		}
		else {			
			return false;
		}
	}

	@Override
	public boolean deleteAllUsers() {
		
		String sql = "delete from user_entity";
		if(jdbcTemplate.update(sql) > 0) {				    
		    return true; 
		}
		else {			
			return false;
		}
	}

	@Override
	public boolean partialUpdateUser(int id, Map<String, Object> updates) {
		
		String query = "select * from user_entity where id=?";
		
		UserEntity user = jdbcTemplate.queryForObject(query, new UserEntityRowMapper(), id);
	
		if(user != null) {
			
			updates.forEach((key,value)-> {
				switch(key) {
				case "firstname":
					user.setFirstname((String) value);;
					break;
				case "lastname":
					user.setLastname((String) value);;
					break;
				default:
					break;
				}
			});
			
			String sql = "update user_entity set firstname=?, lastname=? where id=?";
			if(jdbcTemplate.update(sql, user.getFirstname(), user.getLastname(), id) > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	

}
