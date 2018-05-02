package com.example.service;

import com.example.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final ResourceLoader resourceLoader;

    @Autowired
    public UserServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<User> getAllUsers() throws UserServiceException {
        List<User> userList;
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream stream = resourceLoader.getResource("classpath:user.json").getInputStream();
            userList = mapper.readValue(stream, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException e) {
            throw new UserServiceException("data can not be read");
        }
        return userList;
    }
}