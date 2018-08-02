package com.thoughtworks.training.yuandi.todoservice.service;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import com.thoughtworks.training.yuandi.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo findById(Integer id) {
        return todoRepository.findOne(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Integer id) {
        todoRepository.delete(id);
    }

    public Todo update(Integer id, Todo todo) {
        Todo originalTodo = todoRepository.findOne(id);
        originalTodo.setChecked(todo.isChecked());
        originalTodo.setValue(todo.getValue());
        originalTodo.setTimestamp(todo.getTimestamp());
        originalTodo.setTasks(todo.getTasks());
        return todoRepository.save(originalTodo);
    }
}
