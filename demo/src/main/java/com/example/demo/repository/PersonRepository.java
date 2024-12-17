package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Person;

@Repository
public class PersonRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addPerson(Person person) {
		return jdbcTemplate.update("insert into persons(name, city) values (?, ?)", person.getName(), person.getCity());
	}
	
	public List<Person> getAllPersons(){
		return jdbcTemplate.query("select * from persons", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person getPersonById(int id) {
		return jdbcTemplate.queryForObject("select * from persons where id=?", new PersonRowMapper(), id);
	}
	

	public int update(Person person, int id) {
		return jdbcTemplate.update("update persons set name = ?,"
				+ "city = ? where id = ?", person.getName(), person.getCity(), id);
	}
	
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setName(rs.getString("name"));
			person.setCity(rs.getString("city"));
			person.setId(rs.getInt("id"));
			return person;
		}

		
		
	}

}
