package com.cts.userdetails.controller;

import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.User;
import com.cts.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/RegisterUser")
    public ResponseEntity<String> RegisterUserDetails(@Valid @RequestBody User user)
    {
        return new ResponseEntity(userService.registerUser(user),HttpStatus.CREATED);
    }


    @PutMapping("/UpdateUser")
    public ResponseEntity<String> updateUser(@RequestBody User newEmployeeDetails) throws Exception {
        return new ResponseEntity(userService.UpdateUser(newEmployeeDetails), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> DeleteUserDetails(@PathVariable long id)
    {
        return new ResponseEntity(userService.deleteUser(id),HttpStatus.GONE);
    }

    @GetMapping("/getAllUserData")
    public ResponseEntity<List<User>> getAllUserData() {
        return new ResponseEntity(userService.getAllUser(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> getUserData(@PathVariable long id) {
        return new ResponseEntity(userService.getUserById(id),HttpStatus.ACCEPTED);
    }



    @GetMapping(value = "/loadUserByName/{userName}")
    public Login loadUserByName(@PathVariable long userName){
        return userService.loadUserByName(userName);
    }

    @GetMapping("/fetchRole")
    public String fetchRoleByName(@RequestParam String username)
    {
        return userService.fetchRole(username);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST,code=HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({MethodArgumentNotValidException.class,DataIntegrityViolationException.class})
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
