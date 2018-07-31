package com.thoughtworks.training.yuandi.todoservice.repository;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TodoRepository {

    public List<Todo> list() {
        return Arrays.asList(
                new Todo(1, "todo item 1", false),
                new Todo(2, "todo item 2", true),
                new Todo(3, "todo item 3", false)
        );
    }
}
