import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/model/job';
import { UserService } from '../../services/user.service';
import { ShowjobComponent } from '../showjob/showjob.component';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-enrolljob',
  templateUrl: './enrolljob.component.html',
  styleUrls: ['./enrolljob.component.css']
})
export class EnrolljobComponent implements OnInit {

  id=localStorage.getItem('id');
  jobList:Job[]=[];
  job:Job = new Job();
  token=localStorage.getItem('token');
  constructor(private userservice:UserService) { }
show:boolean=false;
  ngOnInit(): void {

    this.userservice.getAlljob(this.token,'In progress').subscribe(data=>{
      console.log(data);
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


  completedjob(jobId:any)
  {
    this.userservice.completedJobOfEmployee(jobId,this.id,this.token).subscribe((data)=>{
      console.log("completed data is=",data);
Swal.fire({
  icon:'success',
  title:'Job Completed',
  showConfirmButton:false,
  timer:1500

})
      location.reload();
    },(error)=>{
      Swal.fire({
        icon:'error',
        title:'Job is not Completed',
        showConfirmButton:false,
        timer:1500
      
      })
      console.log(error);
    })
  }

  abortedjob(jobId:any)
  {
    this.userservice.abortedjobofEmployee(jobId,this.id,this.token).subscribe((data)=>{
      console.log("aborted job data is=",data);
      Swal.fire({
        icon:'success',
        title:'Job is aborted',
        showConfirmButton:false,
        timer:1500
      
      })
      location.reload();
    },(error)=>{
      console.log(error);
      Swal.fire({
        icon:'error',
        title:'Not aborted',
        showConfirmButton:false,
        timer:1500
      
      })
    })
  }

}
