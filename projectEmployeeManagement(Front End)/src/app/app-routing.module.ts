import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';

const routes: Routes = [{
  path:'add',
  component: CreateEmployeeComponent
},
{
  
  path:'list',
  component:EmployeeListComponent


},
{
  
    path:'details/:id',
    component:EmployeeDetailsComponent
  
},

{
  
  path:'update/:id',
  component:UpdateEmployeeComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
