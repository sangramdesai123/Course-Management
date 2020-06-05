import { Component, OnInit } from '@angular/core';
import { RegistrationService } from '../registration.service';

@Component({
  selector: 'app-trend',
  templateUrl: './trend.component.html',
  styleUrls: ['./trend.component.css']
})
export class TrendComponent implements OnInit {
  courselist: any;
  constructor(private _service: RegistrationService) { }

  ngOnInit(): void {
    let resp = this._service.getAllCourse();
    resp.subscribe((data) => (this.courselist = data));
    
  }

}
