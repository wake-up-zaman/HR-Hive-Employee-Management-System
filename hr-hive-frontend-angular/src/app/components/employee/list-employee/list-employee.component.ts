
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/classes/employee';
import { EmployeeService } from 'src/app/services/employee.service';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class EmployeeComponent implements OnInit{

  employees!: Employee[];
  constructor(
    private employeeService: EmployeeService,
    private router:Router
    ){}

  ngOnInit(): void {
  this.getEmployee();
  }

  private getEmployee(){
    this.employeeService.getEmployee().subscribe(data=>{
      this.employees=data;
    })
  }


  goTOListEmployee(){
    this.router.navigate(['/employees']);
  }

  updateEmployee(id:number){
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe(data=>{
      console.log("result;",data);
      console.log("hit-1");  
      this.ngOnInit();
      console.log("hit-2");  
    })
  }

  createEmployeeRoute(){
    this.router.navigate(['create-employees']);
  }

}





