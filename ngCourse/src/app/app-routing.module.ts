import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginsuccessComponent } from './loginsuccess/loginsuccess.component';
import { RegistrationComponent } from './registration/registration.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { TranningmatrialComponent } from './tranningmatrial/tranningmatrial.component';
import { AddmatrialComponent } from './addmatrial/addmatrial.component';
import { TrendComponent } from './trend/trend.component';
import { SendemailComponent } from './sendemail/sendemail.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'loginsuccess', component: LoginsuccessComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'addcourse', component: AddcourseComponent },
  { path: 'addcourse/:id', component: AddcourseComponent },
  { path: 'tranning', component: TranningmatrialComponent },
  { path: 'addmatrial', component: AddmatrialComponent },
  { path: 'trends', component: TrendComponent },
  { path: 'sendemail', component: SendemailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
