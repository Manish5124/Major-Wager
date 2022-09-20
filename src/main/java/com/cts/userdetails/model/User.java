package com.cts.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String FirstName;

    private String LastName;

    private String Email;

    private String Password;



//    @ManyToOne
//    @JoinColumn(name = "")
//    private Role Role;

//    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//    @JoinColumn(name = "role_id")
//    private Role Role;

}
