package com.example.web.facade;

import com.example.model.User;
import com.example.service.UserService;
import com.example.service.UserServiceException;
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
        try {
            return userService.getAllUsers();
        } catch (UserServiceException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
