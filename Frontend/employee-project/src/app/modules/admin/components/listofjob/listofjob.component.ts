import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/model/job';
import { AdminService } from '../../services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listofjob',
  templateUrl: './listofjob.component.html',
  styleUrls: ['./listofjob.component.css']
})
export class ListofjobComponent implements OnInit {


  no_jobs_available:boolean=true;

  jobList:Job[]=[];
  job:Job = new Job();
  // jobid!:number;
  
  jobToUpdate = {
    jobId:"",
    starttime:"",
    endtime:"",
    profit:"",
    status:"",    
  };



  token=localStorage.getItem('token');
  show:boolean=false;
  constructor(private adminService:AdminService,private datePipe:DatePipe) { }

  ngOnInit(): void {

  this.adminService.getAlljob(this.token).subscribe(data=>{
    console.log("getAllJob="+data);
    const da = JSON.parse(data);
    this.jobList=[];
    
    
    for(let job of da)
    {
      this.jobList.push(job);
    }

    if(!(this.jobList && this.jobList.length>0)){
      this.show = true;
      }
  
    // console.log(this.jobid);
   });



  
}


  edit(job:any)
  {
    this.jobToUpdate=job;
  }


  deleteJob(id:any)
  {
    
    this.adminService.deleteJobById(id,this.token).subscribe(
      (resp)=>{
        console.log(resp);
        Swal.fire({ 
          // position: 'top-end', 
        icon: 'success',
         title: 'Job deleted',
         showConfirmButton: false,timer: 1500 })
  
        location.reload();
      },
      (err)=>{
        Swal.fire({ 
          // position: 'top-end', 
        icon: 'error',
         title: 'Job is not deleted!',
         showConfirmButton: false,timer: 1500 })
  
        console.log(err)}
    );
  }
  UpdateJobData(jobToUpdate:any)
  {
    //  console.log(this.job);
     this.adminService.updateJob(this.jobToUpdate,this.token).subscribe(data=>{

      Swal.fire({ 
        // position: 'top-end', 
      icon: 'success',
       title: 'Job is updated succesfully',
       showConfirmButton: false,timer: 1500 })


      location.reload();
      console.log(data); 

    },
    (error)=>{
      
      Swal.fire({ 
        // position: 'top-end', 
      icon: 'error',
       title: 'Job is not updated!!',
       showConfirmButton: false,timer: 1500 })
    }
    );
  }
}
