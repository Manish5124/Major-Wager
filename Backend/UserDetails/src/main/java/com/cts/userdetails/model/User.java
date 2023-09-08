package com.cts.userdetails.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="Users")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


//    @Pattern(regexp = "^[A-Za-z0-9._]{2,15}$", message = "Name should consists of (A-Z,a-z,0-9,._)")
    private String firstName;


//    @Pattern(regexp = "^[A-Za-z0-9._]{2,15}$", message = "Name should consists of (A-Z,a-z,0-9,._)")
    private String lastName;

//    @NotBlank(message = "Email should not be empty")
//    @Email(regexp = "[A-Za-z0-9!#$%&'*+-/=?^_`{|]+@[A-Za-z0-9.-]+\\.[com,org,net]{3}")
    @Column(unique = true)
    private String email;

//    @NotBlank(message = "password should not be empty")
//    @Pattern(regexp = "^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)^[^/]*$.*$", message = "password should be well formed format")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinTable(name="User_Role",joinColumns =
           {
                    @JoinColumn(name="user_id",referencedColumnName = "id")
            },
            inverseJoinColumns ={
            @JoinColumn(name="role_id",referencedColumnName = "roleId"),
            @JoinColumn(name = "id", referencedColumnName = "id")
            }

    )
    private List<Role> roles;



//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumns( {
//            @JoinColumn(name = "id", referencedColumnName = "id"),
//            @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            @JoinColumn(name = "role_id", referencedColumnName = "roleId"),
////            @JoinColumn(name = "column_4", referencedColumnName = "column_4")
//    })
//    private List<Role> roles;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user_id")
//    //@JsonIgnore
//    private List<Role> roles;

}
