import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../classes/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl="http://localhost:9090/employee";
  constructor(private httpClient: HttpClient) { }

  getEmployee(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseUrl}/GetAllEmployee`)
  }

  createEmployee(employee:Employee):Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}/addEmployee`,employee);
  }

  getEmployeeById(id:number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/findEmployee/${id}`);

  }

  updateEmployee(id:number, employee:Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/updateEmployee/${id}`,employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/deleteEmployee/${id}`);
  }
  
}
