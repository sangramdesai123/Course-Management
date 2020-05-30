import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { FormControl } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { from } from 'rxjs';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { Router } from '@angular/router';
import { AuthService } from "angularx-social-login";
import { GoogleLoginProvider } from "angularx-social-login";
import { SocialUser } from "angularx-social-login";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user=new User();
  msg="";
  public myuser: SocialUser;
  private loggedIn: boolean;

  constructor( private _service : RegistrationService, private _router : Router,private authService: AuthService) { }
  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
  }
  
  ngOnInit(): void {
    this.authService.authState.subscribe((user) => {
      this.myuser = user;
      this.loggedIn = (user != null);
      if(this.loggedIn){
        console.log("responce recived"+this.myuser);
        const userdata=new User();
        userdata.emailId=this.myuser.email;
        userdata.userName=this.myuser.name;
        localStorage.setItem('myuser', JSON.stringify(userdata));
        localStorage.setItem('loginstatus', JSON.stringify(this.loggedIn));
        this._router.navigate(['/dashboard']);
      }
    });
  }

  loginUser(){
    this._service.loginUserFromRemote(this.user).subscribe(
      data => {
        console.log("responce recived");
        localStorage.setItem('myuser', JSON.stringify(this.user));
        this._router.navigate(['/dashboard']);
      },
      error => {
        console.log("Exception ");
        this.msg ="Bad Creadiantional,Enter Valid Email Id Password";
      }
    )
  }

  gotoregistration(){
    this._router.navigate(['/registration']);
  }
}
