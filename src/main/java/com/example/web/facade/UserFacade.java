package com.example.web.facade;

import com.example.model.User;
import com.example.service.UserServiceException;

import java.util.List;

public interface UserFacade {

    List<User> getAllUsers() throws UserServiceException;

}
