import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeComponent } from './components/employee/list-employee/list-employee.component';
import { CreateEmployeeComponent } from './components/employee/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './components/employee/update-employee/update-employee.component';



const routes: Routes = [
  {path:'employees',component: EmployeeComponent},
  {path:'create-employees',component: CreateEmployeeComponent},
  {path:'',redirectTo: 'employees', pathMatch: 'full'},
  {path:'update-employee/:id',component: UpdateEmployeeComponent}
];
 
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
