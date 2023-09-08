import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Job } from 'src/app/model/job';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient) { }


  token=localStorage.getItem('token');

createJob(job: Job,token:any):Observable<Object>
{
  const headers = new HttpHeaders().set('Authorization',token);
  console.log("headers="+token);
  // const headers = {'content-type':'application/json'}
  // const body = JSON.stringify(job);
  // console.log(body)
  return this.httpClient.post<Object>(`/job/createJob`,job,{'headers':headers,responseType:'text' as 'json'});

}

updateJob(job:any,token:any)
{
  const headers = new HttpHeaders().set('Authorization',token);
  // const headers = {'content-type':'application/json'}
  // const body = JSON.stringify(job);
  // console.log(body)
  return this.httpClient.put(`job/modifyJob`,job,{'headers':headers,responseType:'text' as 'json'});

}

getAlljob(token:any):Observable<any>
{
  const headers = new HttpHeaders().set('Authorization',token);
  return this.httpClient.get<any>("job/jobs",{'headers':headers,responseType:'text' as 'json'});
}

deleteJobById(id: any,token:any)
{
  
  const headers = new HttpHeaders().set('Authorization',token);
  return this.httpClient.delete("job/deleteJob?id="+`${id}`,{'headers':headers,responseType:'text' as 'json'});
}



fetchCurrentUserName(empId:any,token:any)
{
  const headers = new HttpHeaders().set('Authorization',token);
  return this.httpClient.get(`employee/fetchUserName/${empId}`,{'headers':headers,responseType:'text'});
}

}
