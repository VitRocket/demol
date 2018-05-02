package com.example.web.controller;

import com.example.model.User;
import com.example.web.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserFacade userFacade;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/user")
    public String greeting(Model model) {
        List<User> userList = userFacade.getAllUsers();
        model.addAttribute("users", userList);
        return "user";
    }
}
