package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        super();
        this.personService = personService;
    }

    //create person REST API
    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    //get all persons REST API
    @GetMapping()
    public List<Person> getAllPerson() {
        return personService.getAllPersons();
    }

    //get person by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") long personId) {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
    }

    //update person REST API
    @PutMapping("{id}")
    public ResponseEntity<Person> updatePersonById(@PathVariable("id") long id
                                                  ,@RequestBody Person person) {
        return new ResponseEntity<>(personService.updatePerson(person, id), HttpStatus.OK);
    }
    //delete person REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>("Person deleted successfully!", HttpStatus.OK);

    }

}
