import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';
import { User } from './user';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Course } from './Course';

@Injectable({
  providedIn: 'root',
})
export class RegistrationService {
  constructor(private _http: HttpClient) {}

  public loginUserFromRemote(user: User): Observable<any> {
    return this._http.post<any>('http://localhost:8080/login', user);
  }

  public registerUserFromRemote(user: User): Observable<any> {
    return this._http.post<any>('http://localhost:8080/registeruser', user);
  }

  public addCourse(course: Course): Observable<any> {
    return this._http.post<any>('http://localhost:8080/addcourse', course, {
      responseType: 'text' as 'json',
    });
  }

  public getAllCourse() {
    return this._http.get<any>('http://localhost:8080/getcourse');
  }

  public getCourseByCreator(creator) {
    return this._http.get<any>('http://localhost:8080/getcourse/' + creator);
  }

  public deleteCourse(id) {
    return this._http.delete<any>('http://localhost:8080/deleteCourse/' + id);
  }
}
