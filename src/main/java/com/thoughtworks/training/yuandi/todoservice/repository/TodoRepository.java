package com.thoughtworks.training.yuandi.todoservice.repository;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
