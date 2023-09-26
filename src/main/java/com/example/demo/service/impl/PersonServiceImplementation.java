package com.example.demo.service.impl;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {

    private PersonRepository personRepository;

    public PersonServiceImplementation(PersonRepository personRepository) {
        super();
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
