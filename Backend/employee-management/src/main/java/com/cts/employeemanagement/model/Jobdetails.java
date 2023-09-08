package com.cts.employeemanagement.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="jobs")
public class Jobdetails  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;


//    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private String starttime;


//    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private String endtime;

    private long profit;

    private String status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private EmployeeDetails engagedEmployee;

}
