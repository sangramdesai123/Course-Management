import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  courselist:any;
  constructor(private _service: RegistrationService) { }

  ngOnInit(): void {
    let resp=this._service.getAllCourse();
    resp.subscribe((data)=> this.courselist=data);
  }

}
