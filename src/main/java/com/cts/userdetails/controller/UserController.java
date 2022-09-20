package com.cts.userdetails.controller;

import com.cts.userdetails.model.User;
import com.cts.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,@RequestBody User newEmployeeDetails) throws Exception {
        return new ResponseEntity(userService.UpdateUser(id,newEmployeeDetails), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String DeleteUserDetails(@PathVariable long id)
    {
        return userService.deleteUser(id);
    }

}
