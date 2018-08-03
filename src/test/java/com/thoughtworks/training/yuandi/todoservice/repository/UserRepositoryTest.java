package com.thoughtworks.training.yuandi.todoservice.repository;

import com.thoughtworks.training.yuandi.todoservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnUserWithName() {
        userRepository.save(new User(0, "user", ""));

        Optional<User> user = userRepository.findByUsernameEquals("user");
        assertTrue(user.isPresent());
        assertThat(user.get().getUsername(), is("user"));
    }
}