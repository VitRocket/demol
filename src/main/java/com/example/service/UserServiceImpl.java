package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Mikle"));
        userList.add(new User(2, "Ivan"));
        return userList;
    }
}
