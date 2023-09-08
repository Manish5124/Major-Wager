import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // username=localStorage.getItem('username');
  quote:any;
  index:any;
  constructor() { }

  ngOnInit(): void {

    this.index = Math.floor(Math.random() * 5) + 1;

    if(this.index===1)
    {
      this.quote="“Whether you think you can, or you think you can’t – you’re right.”";
    }
    else if(this.index===2)
    {
      this.quote="“Oh yes, the past can hurt. But you can either run from it, or learn from it.” ";
    }
    else if(this.index===3)
    {
      this.quote="“The secret of change is to focus all of your energy, not on fighting the old, but on building the new.” ";
    }
    else if(this.index==4)
    {
      this.quote="“The more business a man has to do,the more he is able to accomplish,for he learn to economize his time” ";
    }
    else
    {
      
      this.quote="“Nothing is impossible, the word itself says, “I’m possible!”";
    }
  }

}
