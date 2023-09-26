package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        super();
        this.personService = personService;
    }

    //create person REST API
    @PostMapping()
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }
}
