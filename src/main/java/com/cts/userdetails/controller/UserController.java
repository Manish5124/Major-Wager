package com.cts.userdetails.controller;

import com.cts.userdetails.model.User;
import com.cts.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/RegisterUser")
    public String RegisterUserDetails(@RequestBody User user)
    {
        return userService.RegisterUser(user);
    }

    @DeleteMapping("/deleteUser")
    public String DeleteUserDetails(User user)
    {
        return userService.deleteUser(user);
    }

}
