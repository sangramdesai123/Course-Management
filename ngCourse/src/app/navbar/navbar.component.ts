import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Router } from '@angular/router';
import { AuthService } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';
import { SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  userdata: User = JSON.parse(localStorage.getItem('myuser'));
  constructor(private _router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    const userloginstatus = JSON.parse(localStorage.getItem('loginstatus'));
    console.log(`hi${userloginstatus}`);
    if (!userloginstatus) {
      this._router.navigate(['']);
    }
  }

  signOut(): void {
    localStorage.clear();
    localStorage.setItem('loginstatus', JSON.stringify(false));
    this.authService.signOut();
    this._router.navigate(['']);
  }
}
