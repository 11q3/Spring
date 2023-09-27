package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    List<Person> getAllPersons();
    Person getPersonById(long id);
    Person updatePerson(Person person, long id);
    void deletePerson(long id);
}
