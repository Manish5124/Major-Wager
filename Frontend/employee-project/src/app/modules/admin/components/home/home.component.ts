import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private adminservice:AdminService) { }

  quote:any;
  currentUser!:string;

  ngOnInit(): void {
    var index = Math.floor(Math.random() * 5) + 1;
    console.log("random="+index);

    if(index==1)
    {
      this.quote="“Whether you think you can, or you think you can’t – you’re right.” —Henry Ford";
    }
    else if(index==2)
    {
      this.quote="“Oh yes, the past can hurt. But you can either run from it, or learn from it.” —Rafiki, The Lion King";
    }
    else   {
      this.quote="“The secret of change is to focus all of your energy, not on fighting the old, but on building the new.” – Socrates";
    }

    this.adminservice.fetchCurrentUserName(localStorage.getItem('id'),localStorage.getItem('token')).subscribe((data)=>{
      this.currentUser=data;
    },(error)=>{
      console.log("getting error when fetching the role");

    }
    )

  }


  

}
