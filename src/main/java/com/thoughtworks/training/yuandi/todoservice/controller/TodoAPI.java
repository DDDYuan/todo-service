package com.thoughtworks.training.yuandi.todoservice.controller;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import com.thoughtworks.training.yuandi.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return todoService.findAll();
    }

    @GetMapping(path = "/todos/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
        return todoService.findById(id);
    }

    @PostMapping(path = "/todos")
    public void createTodo(@RequestBody Todo todo) {
        todoService.save(todo);
    }

    @DeleteMapping(path = "/todos/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        todoService.delete(id);
    }

    @PutMapping(path = "/todos/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        todoService.update(id, todo);
    }
}
