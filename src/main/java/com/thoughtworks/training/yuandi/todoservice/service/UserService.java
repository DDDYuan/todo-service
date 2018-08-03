package com.thoughtworks.training.yuandi.todoservice.service;

import com.thoughtworks.training.yuandi.todoservice.model.User;
import com.thoughtworks.training.yuandi.todoservice.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Value("${secretkey}")
    private String secretKey;

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

    public User findByName(String username) {
        return userRepository.findByUsernameEquals(username).get();
    }

    public User create(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public boolean verify(String username, String password) {
        Optional<User> user = userRepository.findByUsernameEquals(username);
        return user.isPresent() && new BCryptPasswordEncoder().matches(password, user.get().getPassword());
    }

    public boolean verify(User user) {
        return verify(user.getUsername(), user.getPassword());
    }

    public String generateToken(String username) {
        return Jwts.builder().setClaims(new HashMap<String, Object>() {{
            put("username", username);
        }}).signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
    }
}
