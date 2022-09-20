package com.cts.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String firstName;


    private String lastName;


    private String email;


    private String password;



    @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="user_role",referencedColumnName = "id")
    public List<Role> roles;

//    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//    @JoinColumn(name = "role_id")
//    private Role Role;

}
