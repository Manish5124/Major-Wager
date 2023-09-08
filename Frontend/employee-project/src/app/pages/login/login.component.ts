import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    userName:'',
    password:''
  };

  constructor(private login:LoginService,private router:Router) { }

  ngOnInit(): void {
  }


  token:any;

  formSubmit(){
  //  if(this.loginData.userName.trim()=='' || this.loginData.userName==null)
  //   {
  //     alert("worng username");
  //   }


    // request to server to generate token
    this.login.generateToken(this.loginData).subscribe((data:any)=>{
      console.log("success");
      console.log(data);

      
    this.token='Bearer '+data;
    console.log("Token =",this.token);

       localStorage.setItem('token',this.token);
       localStorage.setItem('id',this.loginData.userName);
      

      
      this.login.getUserRole(this.loginData.userName,this.token).subscribe(data=>{
       
         
        Swal.fire({ 
          // position: 'top-end', 
        icon: 'success',
        title: 'logged in successfully',
        showConfirmButton: false,timer: 1500 })
        
          console.log(data);
          
          if(data=='manager')
          {
            this.router.navigate(['/admin']);
          }
          else{
            this.router.navigate(['/user']);
          } }) 
    },
    (error)=>{

      Swal.fire({ 
        // position: 'top-end', 
      icon: 'error',
       title: 'Wrong Credential !!',
       showConfirmButton: false,timer: 1500 })

    });

  }


 
}
