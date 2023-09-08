package com.cts.employeemanagement.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDetails implements Serializable {

    @Id
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private long salary;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "engagedEmployee",fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Jobdetails> allocatedjobs;

}
