import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/model/job';
import { UserService } from '../../services/user.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-showjob',
  templateUrl: './showjob.component.html',
  styleUrls: ['./showjob.component.css']
})
export class ShowjobComponent implements OnInit {

  id=localStorage.getItem('id');
  jobList:Job[]=[];
  job:Job = new Job();
  
  // status='Not Started';
  // show:boolean = true;
  show:boolean=false;
  constructor(private userservice:UserService) { }
  token=localStorage.getItem('token');
  showStatus ='Not Started';
  ngOnInit(): void {

    this.userservice.getAlljob(this.token,'Not Started').subscribe(data=>{
      console.log(data);
      const da = JSON.parse(data);

      this.jobList=[];
      
      for(let job of da)
      {
        this.jobList.push(job);
        this.jobList.sort((a,b)=>b.profit-a.profit);
      }
    
      if(!(this.jobList && this.jobList.length>0)){
        this.show = true;
        }
      // console.log(this.jobid);
    });




  }


  allocatejob(jobId:any)
  {

    this.userservice.allocatedJobToEmployee(jobId,this.id,this.token).subscribe((data)=>{
      console.log("allocatedJobData is=",data);

      Swal.fire({
        title:data,
        showClass:{
          popup:'animate__animated animate__fadeInDown'
        },
        hideClass:{
          popup:'animate__animated animate__fadeOutUp'
        }

      })

      if(data=='Job is colliding')
      {
        alert(data);
      }
      location.reload();
    }
    )
    // location.reload();
    // this.status="In progress";
    // this.show =!this.show;
  }

 
}
