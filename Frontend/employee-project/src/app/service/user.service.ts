import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import baseUrl from '../model/helper'; 
import { Job } from '../model/job';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // private baseURL = "http://localhost:8082/user/RegisterUser";

  constructor(private httpClient:HttpClient) { }

  // post mapping

createUser(user: User):Observable<Object>{
  const headers = {'content-type':'application/json'}
  const body = JSON.stringify(user);
  console.log(body)
  return this.httpClient.post<Object>(`${baseUrl}`,body,{'headers':headers,responseType:'text' as 'json'});

  // return this.httpClient.post<Object>(`${this.baseURL}`,user,{responseType:'text' as 'json'});

  // public createUser(User: any)
  // {
  //   return this.httpClient.post(`${baseUrl}`,User);
  // }


}




}