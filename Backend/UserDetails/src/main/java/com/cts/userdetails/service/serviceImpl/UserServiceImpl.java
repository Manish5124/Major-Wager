package com.cts.userdetails.service.serviceImpl;


import com.cts.userdetails.exception.EmptyDataAccessException;
//import com.cts.userdetails.feign.AuthClient;
import com.cts.userdetails.feign.EmployeeClient;
//import com.cts.userdetails.model.AuthenticationRequest;
import com.cts.userdetails.model.EmployeeDetails;
import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.User;
import com.cts.userdetails.repository.UserRepository;
import com.cts.userdetails.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeClient employeeClient;

    public String registerUser(User user){
        if(user==null){
            throw new NullPointerException("Object is null");
        }
        EmployeeDetails employee=new EmployeeDetails();

        if(user.getId()!= 0l)
        {
            employee.setId(user.getId());
        }

        if(user.getFirstName()!=null)
        {
            employee.setFirstName(user.getFirstName());
        }

        if(user.getLastName()!=null)
        {
            employee.setLastName(user.getLastName());
        }

        if(user.getEmail()!=null)
        {
            employee.setEmail(user.getEmail());
        }

        employeeClient.registerEmployee(employee);
        userRepository.save(user);
            return "User is registered successfully.";



    }



    @Override
    public String UpdateUser(User employeeDetails)  throws Exception {

        Long id = employeeDetails.getId();
        User userDetail= userRepository.findById(id).get();


        EmployeeDetails employee = employeeClient.getEmployeeDetailsById(id);

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());


        userDetail.setFirstName(employeeDetails.getFirstName());
        userDetail.setLastName(employeeDetails.getLastName());
        userDetail.setEmail(employeeDetails.getEmail());
        userDetail.setPassword(employeeDetails.getPassword());

        if(employeeDetails.getRoles()!=null) {
            userDetail.setRoles(employeeDetails.getRoles());
        }

        employeeClient.registerEmployee(employee);
        userRepository.save(userDetail);
        return "successfully updated";

    }



    @Override
    public String deleteUser(long id) {
        employeeClient.deleteEmployeeById(id);
        userRepository.deleteById(id);
        return "successfully deleted "+id;
    }



    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    public Login loadUserByName(long userName){
        User user=userRepository.getReferenceById(userName);
        return new Login(user.getId(),user.getPassword());
    }

    @Override
    public String fetchRole(String userName) {
        Optional<User> userData= Optional.of(userRepository.findById(Long.parseLong(userName)).get());
        if(userData.isPresent()) {
            Role roleData = userData.get().getRoles().get(0);

            return roleData.getRoleName();
        }
        return "User is not found";
    }

    @Override
    public User getUserById(long id) {

        return userRepository.findById(id).orElse(null);

    }



}
