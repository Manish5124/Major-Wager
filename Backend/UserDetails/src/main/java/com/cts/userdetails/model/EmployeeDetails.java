package com.cts.userdetails.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class EmployeeDetails implements Serializable {


    @Id
    private long id;

    @Column(name="first_name")
    private String FirstName;

    @Column(name="last_name")
    private String LastName;


    private double Salary;

    @Column(unique = true)
    private String Email;

    @Column(name = "allocated_job")
    private String Allocated_job;

}
