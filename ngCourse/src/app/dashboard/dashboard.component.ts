import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  courselist: any;
  id: any;
  creator: String;
  constructor(private _service: RegistrationService) {}

  public deleteCourse(id: number) {
    let resp = this._service.deleteCourse(id);
    resp.subscribe((data) => (this.courselist = data));
  }

  public searchCoursebyCreator() {
    let resp = this._service.getCourseByCreator(this.creator);
    resp.subscribe((data) => (this.courselist = data));
  }

  ngOnInit(): void {
    let resp = this._service.getAllCourse();
    resp.subscribe((data) => (this.courselist = data));
  }
}
