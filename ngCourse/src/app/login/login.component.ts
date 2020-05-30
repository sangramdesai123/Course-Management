import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { FormControl } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { from } from 'rxjs';
import { RegistrationService } from '../registration.service';
import { User } from '../user';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user=new User();
  msg="";
  constructor( private _service : RegistrationService, private _router : Router) { }

  ngOnInit(): void {
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
