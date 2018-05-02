package com.example.web.controller;

import com.example.service.UserServiceException;
import com.example.web.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserFacade userFacade;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/user")
    public String greeting(Model model) throws UserServiceException {
        model.addAttribute("users", userFacade.getAllUsers());
        return "user";
    }
}
