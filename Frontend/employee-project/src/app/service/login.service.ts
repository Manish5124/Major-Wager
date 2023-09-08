import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  // get user data
  // public getUserData()
  // {
  //   return this.http.get(`http://localhost:8881/user/getAlluser`);
  // }

//  public generateToken(loginData:any):Observable<Object>{
//      const headers = {'content-type':'application/json'};
    // const body = JSON.stringify(loginData);
    // console.log(body)
    // return this.http.post<Object>(`auth/authenticate`,loginData,{'headers':headers,responseType:'text' as 'json'});
 
    // generate token
  public generateToken(loginData:any)
  {
    return this.http.post(`auth/login`,loginData,{responseType: 'text'});
  }



// isLogin: user is logged in or not
// public isLoggedIn()
// {
//   let tokenStr = localStorage.getItem("token");
//   if(tokenStr == undefined || tokenStr == '' || tokenStr == null)
//   {
//     return false;
//   }
//   else
//   {
//     return true;
//   }
// }


// logout:- remove token from local storage
// public logout()
// {
//   localStorage.removeItem('token');
//   localStorage.removeItem('user');
//   localStorage.removeItem('id');
//   return true;
// }


// get token
public getToken(){
  return localStorage.getItem('token');
}

// set the userDetail
// public setUser(user:any)
// {
//   localStorage.setItem('user',JSON.stringify(user));
// }

// get the userDetail
// public getUser(user:any)
// {
//   let userStr = localStorage.getItem('user');
//   if(userStr != null)
//    {
//       return JSON.parse(userStr);
//    }
//    else{
//     this.logout();
//     return null;
//    }

  // }
// get userRole
 public getUserRole(username:any,token:any)
  {
    const headers = new HttpHeaders().set('Authorization',token);
    // const body = JSON.stringify(loginData);
    // console.log(body)
    return this.http.get(`users/fetchRole?username=`+`${username}`,{'headers':headers,responseType:'text' as 'json'});
   }



    // generate token
  // public getUserData(loginData:any)
  // {
  //   return this.http.get(`http://localhost:8881/auth/login`,loginData);

  // }

}

