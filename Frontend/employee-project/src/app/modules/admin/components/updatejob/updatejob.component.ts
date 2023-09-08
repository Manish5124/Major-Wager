import { Component, OnInit } from '@angular/core';
import { Job } from 'src/app/model/job';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-updatejob',
  templateUrl: './updatejob.component.html',
  styleUrls: ['./updatejob.component.css']
})
export class UpdatejobComponent implements OnInit {

  job:Job = new Job();
  
  constructor(private adminService:AdminService) { }

  ngOnInit(): void {
  }

  // formSubmit()
  // {
  //    console.log(this.job);
  //    this.adminService.updateJob(this.job).subscribe(data=>{
  //     console.log(data);
      
  //   });
  // }

}
