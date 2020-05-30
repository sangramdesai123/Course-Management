import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  userdata:User=JSON.parse(localStorage.getItem('myuser'));
  constructor() { }

  ngOnInit(): void {
    console.log(this.userdata)
  }

}
