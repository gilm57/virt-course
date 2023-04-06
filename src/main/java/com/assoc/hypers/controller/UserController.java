package com.assoc.hypers.controller;

import com.assoc.hypers.entity.User;
import com.assoc.hypers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void adminUser(){
        userService.adminUser();
    }
    @PostMapping({"/addUser"})
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin(){
        return "This is for admin only";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('USER')")
    public String forUser(){
        return "This is for USER only";
    }


}
