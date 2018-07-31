package com.thoughtworks.training.yuandi.todoservice.controller;

import com.thoughtworks.training.yuandi.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(path = "/todos")
    public String showList(Model model) {
        model.addAttribute("todos", todoService.getAll());
        return "todos";
    }
}
