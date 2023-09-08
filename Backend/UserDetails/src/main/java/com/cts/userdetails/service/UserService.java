package com.cts.userdetails.service;

import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

  //  registerUser Method helps to register user record and employee record
  public String registerUser(User user);


  //  UpdateUser Method helps to update user record and employee record by id
    public String UpdateUser(User employeeDetails) throws Exception;


  //  deleteUser Method helps to delete user record and employee record by id
    public String deleteUser(long id);

  //  getAllUser Method helps get all data of user
    public List<User> getAllUser();

//    public Login loadUserById(String userName);

//  Login loadUserById(Long id);

    public String fetchRole(String userName);
  public Login loadUserByName(long userName);

    public User getUserById(long id);


}
