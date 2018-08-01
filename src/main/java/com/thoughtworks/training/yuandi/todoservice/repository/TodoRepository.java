package com.thoughtworks.training.yuandi.todoservice.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Repository
public class TodoRepository {
    private final ObjectMapper objectMapper;

    @Value("classpath:static/data/todos.json")
    private Resource resource;

    @Autowired
    public TodoRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Todo> list() {
        try {
            return objectMapper.readValue(resource.getFile(), new TypeReference<List<Todo>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
