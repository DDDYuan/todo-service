package com.thoughtworks.training.yuandi.todoservice.repository;

import com.thoughtworks.training.yuandi.todoservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {
    public List<Person> list() {
        return Arrays.asList(
                new Person("ddd1", "xa1"),
                new Person("ddd2", "xa2"),
                new Person("ddd3", "xa3")
        );
    }
}
