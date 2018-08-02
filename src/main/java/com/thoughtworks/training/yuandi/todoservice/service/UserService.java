package com.thoughtworks.training.yuandi.todoservice.service;

import com.thoughtworks.training.yuandi.todoservice.model.User;
import com.thoughtworks.training.yuandi.todoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public boolean verify(String username, String password) {
        Optional<User> user = userRepository.findByUsernameEquals(username);
        return user.isPresent() && password.equals(user.get().getPassword());
    }
}
