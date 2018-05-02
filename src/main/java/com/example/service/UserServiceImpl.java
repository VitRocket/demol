package com.example.service;

import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("user.json").getFile();
            userList = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
