package com.thoughtworks.training.yuandi.todoservice.service;

import com.thoughtworks.training.yuandi.todoservice.model.Person;
import com.thoughtworks.training.yuandi.todoservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {
    @Autowired
    private PersonRepository personRepository;

    public Person find(String name) {
        List<Person> persons = personRepository.list();
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .get();
    }
}
