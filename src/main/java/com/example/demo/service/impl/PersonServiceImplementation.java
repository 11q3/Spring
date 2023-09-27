package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImplementation implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImplementation(PersonRepository personRepository) {
        super();
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent())
            return person.get();
        else
            throw new ResourceNotFoundException("Person", "Id", id);
    }

    @Override
    public Person updatePerson(Person person, long id) {

        //check if person is present with given id.
        Person existingPerson = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Person", "Id", id));
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        existingPerson.setNumber(person.getNumber());
        //save exist. person to db
        personRepository.save(existingPerson);
        return existingPerson;
    }

    @Override
    public void deletePerson(long id) {
        //check if person is present with given id.
        personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Person", "Id", id));
        personRepository.deleteById(id);
    }
}
