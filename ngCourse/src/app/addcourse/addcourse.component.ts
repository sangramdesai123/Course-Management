import { Component, OnInit } from '@angular/core';
import { Course } from '../Course';
import { RegistrationService } from '../registration.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css'],
})
export class AddcourseComponent implements OnInit {
  course: Course = new Course();
  msg: any;
  id: any;
  constructor(
    private _service: RegistrationService,
    private _activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this._activatedRoute.params.subscribe((params) => {
      if (typeof params['id'] !== 'undefined') {
        this.id = params['id'];
        this._service
          .getCourse(this.id)
          .subscribe((data) => (this.course = data));
      } else {
        this.id = '';
      }
    });
  }

  public addNewCourse() {
    this._service.addCourse(this.course).subscribe((data) => (this.msg = data));
  }

  public updateCourse() {
    this._service
      .updateCourse(this.course)
      .subscribe((data) => (this.msg = data));
  }
}
