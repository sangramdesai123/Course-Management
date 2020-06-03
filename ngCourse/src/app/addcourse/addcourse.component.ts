import { Component, OnInit } from '@angular/core';
import { Course } from '../Course';
import { RegistrationService } from '../registration.service';
@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css'],
})
export class AddcourseComponent implements OnInit {
  course: Course = new Course();
  msg: any;
  constructor(private _service: RegistrationService) {}

  ngOnInit(): void {}

  public addNewCourse() {
    this._service.addCourse(this.course).subscribe((data) => (this.msg = data));
  }
}
