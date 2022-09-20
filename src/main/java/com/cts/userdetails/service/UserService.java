package com.cts.userdetails.service;

import com.cts.userdetails.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

//    Register the user
    public String RegisterUser(User user);

    public String UpdateUser(Long id,  User employeeDetails) throws Exception;

    public String deleteUser(long id);

}
