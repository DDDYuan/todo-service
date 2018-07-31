package com.thoughtworks.training.yuandi.todoservice.controller;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import com.thoughtworks.training.yuandi.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoAPI {
    private final TodoService todoService;

    @Autowired
    public TodoAPI(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/todos")
    public List<Todo> getTodoList() {
        return todoService.getAll();
    }

    @GetMapping(path = "/todos/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        return todoService.getById(id);
    }
}
