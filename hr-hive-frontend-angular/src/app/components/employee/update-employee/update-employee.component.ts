import { EmployeeService } from 'src/app/services/employee.service';
import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/classes/employee';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{
  
  id!:number;
  employee: Employee=new Employee();
  constructor(private employeeService: EmployeeService,
    private route:ActivatedRoute,
    private router:Router
    ){}
  
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee=data;
    },
    error=>{
      console.log("error: ",error);
    });
  }

  goTOListEmployee(){
    this.router.navigate(['/employees']);
  }

  onSubmit(){
   this.employeeService.updateEmployee(this.id,this.employee).subscribe(data=>{
    console.log(data);
    this.goTOListEmployee();
  },
  error=>console.log(error)
  )
  }

}
