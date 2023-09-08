import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { CreatejobComponent } from './components/createjob/createjob.component';
import { HomeComponent } from './components/home/home.component';
import { ListofjobComponent } from './components/listofjob/listofjob.component';
import { UpdatejobComponent } from './components/updatejob/updatejob.component';

const routes: Routes = [
  {path:'',component:AdminDashboardComponent,
  children:[
    {path:'home',component:HomeComponent},
    {path:'about',component:AboutComponent},
    {path:'listofjob',component:ListofjobComponent},
    {path:'createjob',component:CreatejobComponent},
    {path:'updatejob',component:UpdatejobComponent},
    {path:'',redirectTo:'/admin/home',pathMatch:'full'},

  ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
