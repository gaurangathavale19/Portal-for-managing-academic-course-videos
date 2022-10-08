import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/models/User';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  BASEURL = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  user: User = new User();

  public setUser(user: User){
    this.user = user;
    localStorage.setItem('user', JSON.stringify(this.user));
  }

  public userLoginSpringBoot(user: User): Observable<any>{
    return this.http.post(this.BASEURL + "/signIn", user);
  }

  public useRegisterSpringBoot(user: User): Observable<any>{
    return this.http.post(this.BASEURL + "/addUser", user);
  }

}
