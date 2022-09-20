package com.cts.userdetails.service.serviceImpl;

import com.cts.userdetails.model.User;
import com.cts.userdetails.repository.UserRepository;
import com.cts.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public String RegisterUser(User user) {
        userRepository.save(user);
        return "Registration successful";
    }

//    @Override
//    public String UpdateUser(long id) {
//        User user = UserRepository.findById(id).orElse(null);
//        return "successfully updated";
//    }

    @Override
    public String UpdateUser( Long id,  User employeeDetails)  throws Exception {
        User employee = userRepository.findById(id).orElseThrow(() -> new Exception("Not updated"));        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPassword(employeeDetails.getPassword());
        employee.setRoles(employeeDetails.getRoles());

        userRepository.save(employee);
        return "successfully updated";

    }
//    @Override
//    public String  UpdateUser(User newUser) {
//        List<User> participationFound = UserRepository.findByUserId(newUser.getId());
//
//        if (participationFound.isPresent()) {
//            User participationUpdate = participationFound.get();
//            participationUpdate.setFirstName(newUser.getFirstName());
//            participationUpdate.setLastName(newUser.getLastName());
//            participationUpdate.setEmail(newUser.getEmail());
//            participationUpdate.setPassword(newUser.getPassword());
//
//
//            participationUpdate.setRoles(newUser.getRoles());
//
//
//            userRepository.save(participationUpdate);
//            return "successfully updated";
//        } else {
//            return "successfully not updated";
//        }
//    }

    @Override
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "successfully deleted";
    }
}
