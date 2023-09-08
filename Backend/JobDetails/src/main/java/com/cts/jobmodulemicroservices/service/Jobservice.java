package com.cts.jobmodulemicroservices.service;

import com.cts.jobmodulemicroservices.exception.EmptyDataAccessException;
import com.cts.jobmodulemicroservices.feign.EmployeeClient;
import com.cts.jobmodulemicroservices.model.employee;
import com.cts.jobmodulemicroservices.model.job;
import com.cts.jobmodulemicroservices.service.Jobservice;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class Jobservice {

    @Autowired
    private com.cts.jobmodulemicroservices.repository.jobRepository jobRepository;
    @Autowired
    private EmployeeClient employeeClient;


    public List<job> getjob() {
            return jobRepository.findAll();
    }


    public List<job> addJobs(job jobdata) {
        jobdata.setStatus("Not Started");
        jobRepository.save(jobdata);
        return getjob();
    }


    public String deleteJobDataById(long id) {
         jobRepository.deleteById(id);
         return "Successfully deleted job data";
    }


    public job getJobById(long id) {
        job jobs=jobRepository.findById(id).orElse(null);
        return jobs;
    }


    public List<job> getJobDataByStatus(String status) {
        if (jobRepository.findByStatus(status) != null) {
            return jobRepository.findByStatus(status);
        } else {
            throw new NullPointerException("No Jobs available");
        }
    }


    @SneakyThrows
    public boolean isCollideJobs(employee employeeData,job jobData){
        boolean flag=false;
        String startTime=jobData.getStartDate();
        String endTime=jobData.getEndDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime s1 = LocalDateTime.parse(startTime, formatter);
        LocalDateTime e1 = LocalDateTime.parse(endTime, formatter);

        try {

            for(job jobObj:employeeData.getAllocatedJobs())
            {
                LocalDateTime s2=LocalDateTime.parse(jobData.getStartDate());
                LocalDateTime e2=LocalDateTime.parse(jobData.getEndDate());

                if(s1.compareTo(s2)<0 && e1.compareTo(s2)>0 ||
                        s1.compareTo(e2)<0 && e1.compareTo(e2)>0 ||
                        s1.compareTo(s2)<0 && e1.compareTo(e2)>0 ||
                        s1.compareTo(s2)>0 && e1.compareTo(e2)<0 )

                {
                    flag= true;  // jobs are overlap
                    break;
                }
                else {
                    flag= false;  // Jobs are not overlap
                }
            }
        }catch (NullPointerException e){return true;}

        if(flag) return true;  // overlap
        return false;   // not overlap
    }




    public String AddJobToEmployee(long jobid,long empid) throws Exception {


        job jobObj=jobRepository.findById(jobid).orElse(null);

        employee employeeData=employeeClient.getEmployeeDetailsById(empid);
        List<job> jobDetailList=employeeData.getAllocatedJobs();
        jobDetailList.add(jobObj);


//        if(!isCollideJobs(employee,jobDetail)) {
            employeeData.setAllocatedJobs(jobDetailList);
            long a=jobObj.getJobId();
            for(int i=0;i<jobDetailList.size();i++)
            {
                if(a==jobDetailList.get(i).getJobId() )
                {
                    jobDetailList.get(i).setStatus("In progress");
                }
            }
        jobObj.setStatus("In progress");

            employeeClient.registerEmployee(employeeData);
            jobRepository.save(jobObj);

            return "Job added to employee";
//        }
//        else
//        {

//            return "Job is colliding";
//        }
    }




    public String CompleteJob(long jobId,long empid)
    {
        job jobData= jobRepository.findById(jobId).orElse(null);
        employee employeeData=employeeClient.getEmployeeDetailsById(empid);
        List<job> jobDetailList=employeeData.getAllocatedJobs();
        long a=jobData.getJobId();
        jobDetailList.add(jobData);


        for(int i=0;i<jobDetailList.size();i++)
        {

            if(a==jobDetailList.get(i).getJobId())
            {
                jobData.setStatus("Completed");
                jobDetailList.get(i).setStatus("Completed");
                jobRepository.save(jobData);
                employeeData.setSalary(employeeData.getSalary()+jobData.getProfit());
//                employee.getAllocatedJobs().remove(i);
                employeeClient.registerEmployee(employeeData);

//                employee.setAllocatedJobs(null);

                employeeData.getAllocatedJobs().remove(i);

            }
        }

        Timer timer=new Timer(60*1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobData.setStatus("NotStarted");
                employeeClient.registerEmployee(employeeData);
                jobRepository.save(jobData);
            }
        });
        timer.setRepeats(false);
        timer.start();

        return "Job is Completed";

    }


    public String aborteJob(long jobId,long empid)
    {
        job jobDetail= jobRepository.findById(jobId).orElse(null);
        employee employee=employeeClient.getEmployeeDetailsById(empid);
        List<job> jobDetailList=employee.getAllocatedJobs();
        long a=jobDetail.getJobId();
        jobDetailList.add(jobDetail);
        for(int i=0;i<jobDetailList.size();i++)
        {
            if(a==jobDetailList.get(i).getJobId())
            {
//                    jobDetailList.get(i).setStatus("Aborted");
//                    jobDetailList.remove(employeeFeign.getjob(empid).get(i));
//                    employee.getAllocatedJobs().remove(jobDetail);
                jobDetail.setStatus("Aborted");
                jobDetailList.get(i).setStatus("Aborted");
                jobRepository.save(jobDetail);
                jobDetailList.remove(i);
                employeeClient.registerEmployee(employee);




            }
        }
        Timer timer=new Timer(60*1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jobDetail.setStatus("NotStarted");
                employeeClient.registerEmployee(employee);

                jobRepository.save(jobDetail);
            }
        });
        timer.setRepeats(false);
        timer.start();

        return "Job is aborted";
    }




    @SneakyThrows
    public List<job> UpdateJobs(job jobData){
        Optional<job> previousJob=jobRepository.findById(jobData.getJobId());
        if(previousJob.isPresent()){
            previousJob.ifPresent(Data->{

                Data.setStartDate(jobData.getStartDate());
                Data.setEndDate(jobData.getEndDate());
                Data.setProfit(jobData.getProfit());
                Data.setStatus(jobData.getStatus());
                jobRepository.save(Data);
            });
        }
        else{
            throw new EmptyDataAccessException("No Data is found with this id");
        }
        return getjob();
    }



}
