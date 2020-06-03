import { Component, OnInit } from '@angular/core';
import { TrainingService } from '../training.service';

@Component({
  selector: 'app-tranningmatrial',
  templateUrl: './tranningmatrial.component.html',
  styleUrls: ['./tranningmatrial.component.css'],
})
export class TranningmatrialComponent implements OnInit {
  matriallist: any;
  course: String;
  constructor(private _service: TrainingService) {}

  public deleteMatrial(course: string) {
    let resp = this._service.deleteMatrial(course);
    resp.subscribe((data) => (this.matriallist = data));
  }

  public searchMatrialbyCourse() {
    let resp = this._service.getCourseByCourse(this.course);
    resp.subscribe((data) => (this.matriallist = data));
  }

  ngOnInit(): void {
    let resp = this._service.getAllmatrial();
    resp.subscribe((data) => (this.matriallist = data));
  }
}
