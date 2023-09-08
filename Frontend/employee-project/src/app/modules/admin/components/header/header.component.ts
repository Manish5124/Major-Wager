import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout()
  {
    Swal.fire({ 
      // position: 'top-end', 
    icon: 'success',
     title: 'logout successfully',
     showConfirmButton: false,timer: 1500 })

  localStorage.removeItem('token');
  localStorage.removeItem('id');
  this.router.navigate(['/']);
  }
}
