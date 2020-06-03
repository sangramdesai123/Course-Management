import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Matrial } from './Matrial';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TrainingService {
  constructor(private _http: HttpClient) {}

  public getAllmatrial() {
    return this._http.get<any>('http://localhost:8080/getmatrial');
  }

  public getCourseByCourse(course) {
    return this._http.get<any>('http://localhost:8080/getmatrial/' + course);
  }

  public addCourse(matrial: Matrial): Observable<any> {
    return this._http.post<any>('http://localhost:8080/addmatrial', matrial, {
      responseType: 'text' as 'json',
    });
  }

  public deleteMatrial(course) {
    return this._http.delete<any>(
      'http://localhost:8080/deletematrial/' + course
    );
  }
}
