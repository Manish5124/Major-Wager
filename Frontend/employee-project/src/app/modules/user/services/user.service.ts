import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/model/employee';
import { User } from 'src/app/model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient:HttpClient) { }

  getAlljob(token:any,status:any):Observable<any>
  {
    const headers = new HttpHeaders().set('Authorization',token);
    return this.httpClient.get<any>(`job/getJobByStatus/${status}`,{'headers':headers,responseType: 'text' as 'json'});
  }
  
  
  getEmployeeById(id:any,token:any)
  {
    console.log("getemployeebyid token is",token);

 const headers = new HttpHeaders().set('Authorization', token);
  console.log(headers);
// return this._http.get<Employee>(`emp/EmployeeDetail/${userName}`,{'headers':headers,responseType:'text' as 'json'});


    
    return this.httpClient.get<Employee>(`employee/EmployeeDetail/${id}`,{'headers':headers});
  }




  

  // getUserById(id:any,token:any)
  // {
    // const headers = {'content-type':'application/json'}
    // const headers = new HttpHeaders().set('Authorization',token);
    // const body = JSON.parse(User);
    // console.log(body)
    // return this.httpClient.get<User>(`http://localhost:8082/user/getUserById/`,body);
  //   return this.httpClient.get<Employee>(`employee/EmployeeDetail?id=`+`${id}`,{'headers':headers});
  // }


  FetchRole(id:any,token:any)
  {
    
    const headers = new HttpHeaders().set('Authorization',token);
    return this.httpClient.get("users/fetchRole?username="+`${id}`,{'headers':headers,responseType:'text'});
  }


// updateEmployee(user:any,token:any)
//   {
//     const headers = new HttpHeaders().set('Authorization',token);
//     // const body = JSON.stringify(user);
//     // console.log(body)
//     return this.httpClient.put(`users/UpdateUser`,user,{'headers':headers});
  
//   }

  updateEmployee(user:any,token:any)
  {
    const headers = new HttpHeaders().set('Authorization',token);
    return this.httpClient.put(`users/UpdateUser`,user,{'headers':headers,responseType:'text'});

  }

  allocatedJobToEmployee(jobId:any,empId:any,token:any)
  {
    const headers = new HttpHeaders().set('Authorization',token);
    return this.httpClient.get(`job/allocateJob/${jobId}/${empId}`,{'headers':headers,responseType:'text'});


  }

  completedJobOfEmployee(jobId:any,empId:any,token:any)
  {
    const headers = new HttpHeaders().set('Authorization',token);
    return this.httpClient.get(`job/completeJob/${jobId}/${empId}`,{'headers':headers,responseType:'text'});

  }

  
  abortedjobofEmployee(jobId:any,empId:any,token:any)
  {
    const headers = new HttpHeaders().set('Authorization',token);
    return this.httpClient.get(`job/abortJob/${jobId}/${empId}`,{'headers':headers,responseType:'text'});

  }

}
