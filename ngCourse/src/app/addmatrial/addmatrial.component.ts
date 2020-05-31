import { Component, OnInit } from '@angular/core';
import { TrainingService } from '../training.service';
import { Matrial } from '../Matrial';

@Component({
  selector: 'app-addmatrial',
  templateUrl: './addmatrial.component.html',
  styleUrls: ['./addmatrial.component.css']
})
export class AddmatrialComponent implements OnInit {

  matrial:Matrial=new Matrial();
  msg:any;

  constructor(private _service:TrainingService) { }

  ngOnInit(): void {
  }

  public addNewMatrial(){
    this._service.addCourse(this.matrial).subscribe((data)=>this.msg=data);
  }

}
