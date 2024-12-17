package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public Person addPerson(Person person) {
		if(personRepository.addPerson(person) >0 ) {
			return person;
		}
		else
			return null;		
	}
	
	public List<Person> getAllPersons() {
		return personRepository.getAllPersons();
	}
	
	public Person getPersonById(int id) {
		return personRepository.getPersonById(id);
	}

	public ResponseEntity<?> updatePerson(Person person, int id) {
		if(personRepository.update(person, id) > 0)
		{
			return ResponseEntity.ok(person);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
		}
	}
}
