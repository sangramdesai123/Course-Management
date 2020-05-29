import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  courselist:any;
  id:any;
  constructor(private _service: RegistrationService) { }

  public deleteCourse(id:number){
    let resp=this._service.deleteCourse(id);
    resp.subscribe((data)=> this.courselist=data);
  }

  public searchCoursebyId(){
    let resp=this._service.getCourseById(this.id);
    resp.subscribe((data)=> this.courselist=data);
  }

  ngOnInit(): void {
    let resp=this._service.getAllCourse();
    resp.subscribe((data)=> this.courselist=data);
  }

}
