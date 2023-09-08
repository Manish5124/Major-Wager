import { Component, OnInit } from '@angular/core';
// import { interval, timer } from 'rxjs';
import { Job } from 'src/app/model/job';
import { UserService } from '../../services/user.service';



@Component({
  selector: 'app-myjob',
  templateUrl: './myjob.component.html',
  styleUrls: ['./myjob.component.css']
})
export class MyjobComponent implements OnInit {


  id=localStorage.getItem('id');
  jobList:Job[]=[];
  job:Job = new Job();
  token=localStorage.getItem('token');


  constructor(private userservice:UserService) { }

  show:Boolean=false;
  // da:number=0;
  ngOnInit(): void {

   
    this.userservice.getAlljob(this.token,'Completed').subscribe(data=>{
      // setTimeout(
      //   ()=>{
      //     console.log("data is showing"),4000
      //   }
      // )
      console.log(data);
      
      const da = JSON.parse(data);
      
      // if(da.isEmpty)
      // {
      //   this.show=true;
      // }

      this.jobList=[];

      // if(this.jobList==null)
      // {
      //   this.show=true;
      // }
      
      for(let job of da)
      {
        this.jobList.push(job);
      }

      if(!(this.jobList && this.jobList.length>0)){
        this.show = true;
        }

    
      // console.log(this.jobid);
    });


    // const obs= interval(10);
    // const obs = timer(10000,10)
    // obs.subscribe((d)=>{
    //   console.log(d);
    //   this.da = d;
    // })

  }

  go()
  {
    // const obs = timer(1000)
    // obs.subscribe((d)=>{
    //   console.log(d);
    //   this.da = d;
    // })



  }

}
