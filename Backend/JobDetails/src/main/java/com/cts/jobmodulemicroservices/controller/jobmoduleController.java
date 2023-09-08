package com.cts.jobmodulemicroservices.controller;

import com.cts.jobmodulemicroservices.model.job;
import com.cts.jobmodulemicroservices.service.Jobservice;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class jobmoduleController {

    @Autowired
    private Jobservice jobservice;

    @GetMapping("/getalljobs")
    public List<job> getAllJobsDetails()
    {
        return  jobservice.getjob();
    }

    @PostMapping("/addJob")
    public List<job> addJob(@RequestBody job jobdetails)
    {
        return  jobservice.addJobs(jobdetails);
    }

    @GetMapping("/getjobById/{id}")
    public job getJobById(@PathVariable int id){
        return jobservice.getJobById(id);
    }

    @SneakyThrows
    @PutMapping("/updateJob")
    public List<job> modifyJobDetail(@RequestBody job jobdetails) {
        return  jobservice.UpdateJobs(jobdetails);
    }

    @GetMapping("/abortJob/{jobId}/{empId}")
    public String abortJob(@PathVariable long jobId, @PathVariable long empId) {
        return JSONObject.quote(jobservice.aborteJob(jobId,empId));
    }

    @GetMapping("/getJobByStatus/{status}")
    public List<job> getJobsById(@PathVariable String status) {
        return jobservice.getJobDataByStatus(status);
    }


    @DeleteMapping("/deleteJob")
    public String deleteJob(@RequestParam long id)
    {
        return jobservice.deleteJobDataById(id);
    }


    @SneakyThrows
    @GetMapping("/allocateJob/{jobId}/{empId}")
    public String allocateJob(@PathVariable long jobId,@PathVariable long empId) {
        return JSONObject.quote(jobservice.AddJobToEmployee(jobId,empId));
    }

    @GetMapping("/completeJob/{jobId}/{empId}")
    public String completeJob(@PathVariable long jobId,@PathVariable long empId ) {
        return JSONObject.quote(jobservice.CompleteJob(jobId,empId));
    }





}
