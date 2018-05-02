package com.example.service;

import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() throws UserServiceException {
        List<User> userList;
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileInputStream stream = new FileInputStream(getPath());
            userList = mapper.readValue(stream, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            throw new UserServiceException("data can not be read");
        }
        return userList;
    }

    private String getPath() throws UserServiceException {
        URL url = ClassLoader.getSystemResource("user.json");
        System.out.println(url);
        if (url == null) {
            throw new UserServiceException("data can not be read");
        }
        return url.getPath();
    }
}