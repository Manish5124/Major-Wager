import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { ListofjobComponent } from './components/listofjob/listofjob.component';
import { CreatejobComponent } from './components/createjob/createjob.component';
import { UpdatejobComponent } from './components/updatejob/updatejob.component';
import { HttpClientModule } from '@angular/common/http';
import {MatIconModule} from '@angular/material/icon'

@NgModule({
  declarations: [
    AdminDashboardComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    ListofjobComponent,
    CreatejobComponent,
    UpdatejobComponent

  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatIconModule,
    FormsModule,
    HttpClientModule
  ]
})
export class AdminModule { }
