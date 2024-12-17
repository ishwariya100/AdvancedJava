package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Person;
import com.example.demo.service.PersonService;

@RestController
public class Controller {
	
	@Autowired
	PersonService personService;
	
	@PostMapping(value="/add")
	public Person add(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@GetMapping(value="/getAllPersons")
	public List<Person> getAll(){
		return personService.getAllPersons();
	}
	
	@GetMapping(value= "/getById/{id}")
	public Person getById(@PathVariable (name="id")int id) {
		return personService.getPersonById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePerson(@RequestBody Person person, @PathVariable (name = "id") int id){
		return personService.updatePerson(person, id);
	}
}
