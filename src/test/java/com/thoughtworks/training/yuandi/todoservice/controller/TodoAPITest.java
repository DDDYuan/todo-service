package com.thoughtworks.training.yuandi.todoservice.controller;

import com.thoughtworks.training.yuandi.todoservice.model.Todo;
import com.thoughtworks.training.yuandi.todoservice.model.User;
import com.thoughtworks.training.yuandi.todoservice.repository.TodoRepository;
import com.thoughtworks.training.yuandi.todoservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TodoAPITest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoRepository todoRepository;

    @MockBean
    private UserService userService;
    private User userFixture = new User(1, "ddd", "ddd");

    @Test
    public void shouldReturnItemList() throws Exception {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("ddd", null, Collections.emptyList()));
        when(userService.findByName("ddd")).thenReturn(userFixture);
        when(todoRepository.findAllByUserIdEquals(1)).thenReturn(Collections.singletonList(new Todo(1, "content", false, new Date(), 1, Collections.emptyList())));

        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].value").value("content"))
                .andExpect(jsonPath("$[0].checked").value(false))
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    public void shouldUnauthenticatedBeforeLogin() throws Exception {
        mockMvc.perform(get("/todos")).andExpect(unauthenticated());
    }

    @Test
    public void shouldReturnListWhenAuthenticated() throws Exception {
        when(userService.findByName("ddd")).thenReturn(userFixture);
        when(todoRepository.findAllByUserIdEquals(1)).thenReturn(Collections.singletonList(new Todo(1, "content", false, new Date(), 1, Collections.emptyList())));

        mockMvc.perform(get("/todos")
                .with(authentication(new UsernamePasswordAuthenticationToken("ddd", null, Collections.emptyList()))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].value").value("content"))
                .andExpect(jsonPath("$[0].checked").value(false))
                .andExpect(jsonPath("$.length()").value(1));
    }
}