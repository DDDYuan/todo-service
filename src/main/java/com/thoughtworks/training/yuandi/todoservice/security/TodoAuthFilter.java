package com.thoughtworks.training.yuandi.todoservice.security;

import com.thoughtworks.training.yuandi.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class TodoAuthFilter extends OncePerRequestFilter {
    private final UserService userService;

    @Autowired
    public TodoAuthFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(token)) {
            if (validateToken(token)) {
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(
                                "user",
                                null,
                                Collections.emptyList()));
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean validateToken(String token) {
        String[] userPass = token.split(":");
        String username = userPass[0];
        String password = userPass[1];
        return userService.verify(username, password);
    }
}
