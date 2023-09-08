import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Job } from 'src/app/model/job';
import { AdminService } from '../../services/admin.service';
import Swal from 'sweetalert2';
import { NgForm } from '@angular/forms';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-createjob',
  templateUrl: './createjob.component.html',
  styleUrls: ['./createjob.component.css']
})
export class CreatejobComponent implements OnInit {

  job:Job = new Job();

  constructor(private adminService:AdminService,private router:Router,private datePipe:DatePipe) { }

  ngOnInit(): void {
  }

  token = localStorage.getItem('token');
  
  @ViewChild('jobForm')
  form!:NgForm;

  formSubmit()
  {

   

    let jobDetail=this.form.form.value;
    
     jobDetail.starttime=this.datePipe.transform(this.job.starttime, 'dd-MM-yyyy hh:mm');

     console.log("start time is = "+jobDetail.starttime);

    //  console.log("job start data is"+this.job.starttime);
    
     
     jobDetail.endtime=this.datePipe.transform(this.job.endtime, 'dd-MM-yyyy hh:mm');
     console.log("end time is = "+jobDetail.endtime);

    //  console.log("job endtime is="+this.job.endtime);
    
    jobDetail.profit=this.job.profit;

    console.log("the jobDetail is : ",jobDetail);


     console.log("job data is="+this.job);
     console.log("got token="+this.token);
     this.adminService.createJob(this.job,this.token).subscribe(data=>{
      console.log(data);
      Swal.fire({ 
        // position: 'top-end', 
      icon: 'success',
       title: 'Job is succesfully created',
       showConfirmButton: false,timer: 1500 })


      this.router.navigate(['admin']);
    },
    (error)=>{
      Swal.fire({ 
        // position: 'top-end', 
      icon: 'error',
       title: 'Job is not created!!',
       showConfirmButton: false,timer: 1500 })
console.log("error is "+error);

    });
  }


}
