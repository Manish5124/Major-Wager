package com.cts.userdetails.service.serviceImpl;

import com.cts.userdetails.model.User;
import com.cts.userdetails.repository.UserRepository;
import com.cts.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public String RegisterUser(User user) {
        userRepository.save(user);
        return "Registration successful";
    }

//    @Override
//    public String UpdateUser(User user) {
//        return "successfully updated";
//    }

    @Override
    public String deleteUser(User user) {
        userRepository.delete(user);
        return "successfully deleted";
    }
}
