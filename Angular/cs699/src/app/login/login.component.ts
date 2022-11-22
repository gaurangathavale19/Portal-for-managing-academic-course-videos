import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/models/User';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  usernameFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  passwordFormControl = new FormControl(null, [
    Validators.required,
  ]);

  user: User = new User();
  email: String;
  message: String = '';

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {
  }

  login() {
    if(this.user.userName == null || this.user.password == null){
      location.reload();
    }
    console.log(this.user);
    this.loginService.userLoginSpringBoot(this.user).subscribe(
      resp => {
        this.user = resp;
        // console.log(resp);
        console.log("Username: " + this.user);
        this.loginService.setUser(this.user);
        if(resp!=null)
          this.router.navigate(['/homepage']);
        else
          location.reload();
      },
      error => {
        console.log("Invalid Creds");
      }
    );
  }

}
