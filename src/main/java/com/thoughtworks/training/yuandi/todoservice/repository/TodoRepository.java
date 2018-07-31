package com.thoughtworks.training.yuandi.todoservice.repository;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TodoRepository {

    public List<Todo> list() {
        return Arrays.asList(
                new Todo(1, "content1"),
                new Todo(2, "content2"),
                new Todo(3, "content3")
        );
    }
}
