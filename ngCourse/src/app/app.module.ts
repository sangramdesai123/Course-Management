import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegistrationService } from './registration.service';
import { AddcourseComponent } from './addcourse/addcourse.component';
import { TranningmatrialComponent } from './tranningmatrial/tranningmatrial.component';
import { SocialLoginModule, AuthServiceConfig } from 'angularx-social-login';
import {
  GoogleLoginProvider,
  FacebookLoginProvider,
} from 'angularx-social-login';
import { TrainingService } from './training.service';
import { AddmatrialComponent } from './addmatrial/addmatrial.component';
import { TrendComponent } from './trend/trend.component';
import { SendemailComponent } from './sendemail/sendemail.component';
import { NotfounndComponent } from './notfounnd/notfounnd.component';
let config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider(
      '1065635505813-lb0ckfeml5ucrggnhbjnj0rudpjln3k3.apps.googleusercontent.com'
    ),
  },
]);
export function provideConfig() {
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    DashboardComponent,
    NavbarComponent,
    AddcourseComponent,
    TranningmatrialComponent,
    AddmatrialComponent,
    TrendComponent,
    SendemailComponent,
    NotfounndComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    SocialLoginModule,
  ],
  providers: [
    RegistrationService,
    TrainingService,
    {
      provide: AuthServiceConfig,
      useFactory: provideConfig,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
