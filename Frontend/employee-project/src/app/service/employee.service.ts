import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient:HttpClient) { }

  // getEmployeeList():Observable<object>{

  //   // let tokenStr= "Bearer "+token;
  //   let url = 'http://localhost:8081/employee/EmployeeDetail';
  //   // const headers = new HttpHeaders.set('Access-Control-Allow-Origin','*').set('Content-Type','application/json; charset=utf-8').set('Authorization',tokenStr);

  //   // let request={
    //   "employee":employee
    // }

    // return this.httpClient.get<object>(url);

  }



  
// createUser(user: User):Observable<Object>{
//   const headers = {'content-type':'application/json'}
//   const body = JSON.stringify(user);
//   console.log(body)
//   return this.httpClient.post<Object>(`${baseUrl}`,body,{'headers':headers,responseType:'text' as 'json'});

// }
