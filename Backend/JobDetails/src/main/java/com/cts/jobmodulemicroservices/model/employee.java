package com.cts.jobmodulemicroservices.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class employee {

    @Id
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    private long salary;

    @Column(unique = true)
    private String email;

    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @ElementCollection
    private List<job> allocatedJobs;
}
