import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Role } from 'src/app/model/role';
import { User } from 'src/app/model/user'; 
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User =new  User();

  roleModel:Role = new Role();
  roleList:Role[] = [];
  // roles=['manager','user'];

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
  }
  

  

  addUser(){
    // console.log(this.user);
    if(this.roleModel.roleName=='manager')
    {
      this.roleModel.roleId=1;
      
    }
    else{
      this.roleModel.roleId=2;
    }
    this.roleList.push(this.roleModel);
    
    this.user.roles = this.roleList;

    

    this.userService.createUser(this.user).subscribe(data=>{
      console.log(data);
      this.roleList.pop()?.roleId;
      this.roleList.pop()?.roleName;

   
      var Toas= Swal.mixin({ toast: true,position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,didOpen: (toast) => {   toast.addEventListener('mouseenter', Swal.stopTimer) 
     toast.addEventListener('mouseleave', Swal.resumeTimer) } }) 

     Toas.fire({ icon: 'success', title: 'Signed in successfully' })
     this.router.navigate(['/login']);
  },
  (error)=>{
      // console.log(error);
      var Toas= Swal.mixin({ toast: true,position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,didOpen: (toast) => {   toast.addEventListener('mouseenter', Swal.stopTimer) 
        toast.addEventListener('mouseleave', Swal.resumeTimer) } }) 

    Toas.fire({
      title:'Wrong Credential',
      icon:'error'
    });
    

    });


  }

}
