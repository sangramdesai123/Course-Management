import { Component, OnInit } from '@angular/core';
import { AuthService } from "angularx-social-login";
import { GoogleLoginProvider } from "angularx-social-login";
import { SocialUser } from "angularx-social-login";
import { Router } from '@angular/router';
import { User } from '../user';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user=new User();
  private loggedIn: boolean;
  public msg="";
  constructor(private _service : RegistrationService,private authService: AuthService,private _router : Router) { }

  gotologin(){
    this._router.navigate(['/']);
  }

  registerUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
      data => {
        console.log("responce recived");
        this._router.navigate(['/login']);
      },
      error => {
        console.log("Exception ");
        this.msg ="Bad Creadiantional,Enter Valid Email Id Password";
      }
    )
  }

  ngOnInit(): void {
        
  }

}
