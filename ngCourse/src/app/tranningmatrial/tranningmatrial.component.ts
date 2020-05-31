import { Component, OnInit } from '@angular/core';
import { TrainingService } from '../training.service';

@Component({
  selector: 'app-tranningmatrial',
  templateUrl: './tranningmatrial.component.html',
  styleUrls: ['./tranningmatrial.component.css']
})
export class TranningmatrialComponent implements OnInit {
  matriallist:any;
  constructor(private _service:TrainingService) { }

  public deleteMatrial(course:string){
    let resp=this._service.deleteMatrial(course);
    resp.subscribe((data)=> this.matriallist=data);
  }

  ngOnInit(): void {
    let resp=this._service.getAllmatrial();
    resp.subscribe((data)=> this.matriallist=data);
  }

}
