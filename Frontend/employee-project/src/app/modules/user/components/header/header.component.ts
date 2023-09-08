import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/model/employee';
import { User } from 'src/app/model/user';
import { UserService } from '../../services/user.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  id = localStorage.getItem('id');
  token = localStorage.getItem('token');
  role: any;
  // salary!:number;


  userToUpdate = {
  id: "",
  firstName: "",
  lastName: "",
  email: "",
  password:"",
  
  };

  
 
  
  employee:Employee=new Employee();
  // user:User = new User();

  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    
    // this.userService.getUserById(this.id).subscribe((data)=>{
    //   console.log("Employee data: "+data);
    //   this.user=data;
    // },
    // (error)=>{
    //   console.log(error)
    // });

    // console.log("token outside the ngonit      "+this.token);
     
    this.userService.getEmployeeById(this.id,this.token).subscribe((data)=>{
      // console.log("Emplyoee Data is :"+data);
      this.employee=data;
        console.log("Emplyoee Data is :"+this.employee.firstName);
        // console.log("salary=",this.employee.salary);
        // localStorage.setItem('username',this.employee.firstName);
    },
    (error)=>{
      // alert("you are getting wrong employee data");
      console.log(error)});
   
    this.userService.FetchRole(this.id,this.token).subscribe((data)=>{
      console.log("user role is: "+data);
      this.role=data;
    },
    (error)=>{
      // alert("something wrong in  fetching the role");
      console.log(error)}
    );
  
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
  edit(employee:any)
  {
    this.userToUpdate=employee;
  }


  UpdateEmployeeData(userToUpdate:any)
  {
    //  console.log(this.job);
    // localStorage.removeItem('username');
    // localStorage.setItem('username',this.userToUpdate.firstName);
     this.userService.updateEmployee(userToUpdate,this.token).subscribe(data=>{
 
      var Toas= Swal.mixin({ toast: true,position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,didOpen: (toast) => {   toast.addEventListener('mouseenter', Swal.stopTimer) 
        toast.addEventListener('mouseleave', Swal.resumeTimer) } }) 
      
        Toas.fire({ icon: 'success', title: 'successfully Submited' })
     location.reload();
      console.log(data);
      
    },(error)=>{
      var Toas= Swal.mixin({ toast: true,position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,didOpen: (toast) => {   toast.addEventListener('mouseenter', Swal.stopTimer) 
        toast.addEventListener('mouseleave', Swal.resumeTimer) } }) 
      
          Toas.fire({
            title:'Not updated',
            icon:'error'
          });
    });
  }
}
