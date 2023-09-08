import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnrolljobComponent } from './components/enrolljob/enrolljob.component';
import { HomeComponent } from './components/home/home.component';
import { MyjobComponent } from './components/myjob/myjob.component';
import { ShowjobComponent } from './components/showjob/showjob.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';

const routes: Routes = [
  {
    path:'',component:UserDashboardComponent,
  children:[
    {path:'home',component:HomeComponent},
    {path:'showjob',component:ShowjobComponent},
    {path:'enrolljob',component:EnrolljobComponent},
    {path:'myjob',component:MyjobComponent},
    {path:'',redirectTo:'/user/home',pathMatch:'full'}
  ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
