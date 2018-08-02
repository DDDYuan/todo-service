package com.thoughtworks.training.yuandi.todoservice.repository;

import com.thoughtworks.training.yuandi.todoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameEquals(String username);
}
