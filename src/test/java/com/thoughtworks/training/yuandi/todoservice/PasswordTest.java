package com.thoughtworks.training.yuandi.todoservice;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertTrue;

public class PasswordTest {
    @Test
    public void shouldEncryptPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
        System.out.println(encoder.encode("password"));
        System.out.println(encoder.encode("password"));
        System.out.println(encoder.encode("password"));
        boolean matches = encoder.matches("password", "$2a$10$3XfaCm/UkAbWTqk/lKFV5.g1Z8pKlyJUAT8j7JSnl0zU1hh44jQa.");
        assertTrue(matches);
    }
}
