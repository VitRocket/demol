package com.example.web.facade;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    @Autowired
    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
