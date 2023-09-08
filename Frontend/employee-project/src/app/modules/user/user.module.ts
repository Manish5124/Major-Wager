import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { ShowjobComponent } from './components/showjob/showjob.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { FooterComponent } from './components/footer/footer.component';
import {MatIconModule} from '@angular/material/icon'
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { EnrolljobComponent } from './components/enrolljob/enrolljob.component';
import { MyjobComponent } from './components/myjob/myjob.component';

@NgModule({
  declarations: [
    HeaderComponent,
    HomeComponent,
    ShowjobComponent,
    UserDashboardComponent,
    FooterComponent,
    EnrolljobComponent,
    MyjobComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    MatIconModule,
    HttpClientModule,
    FormsModule
  ]
})
export class UserModule { }
