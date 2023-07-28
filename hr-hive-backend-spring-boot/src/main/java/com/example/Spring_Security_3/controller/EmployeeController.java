package com.example.Spring_Security_3.controller;

import com.example.Spring_Security_3.entity.Employee;
import com.example.Spring_Security_3.payload.DeleteResponse;
import com.example.Spring_Security_3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/addAllEmployee")
    public List<Employee> addAllEmployee(@RequestBody  List<Employee> employees){
        return employeeService.saveAllEmployee(employees);
    }

    @GetMapping("/findEmployee/{id}")
    public Employee findEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/GetAllEmployee")
    public List<Employee> findAllEmployee() {
        return employeeService.getEmployees();
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){

        return employeeService.updatedEmployee(id,employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public DeleteResponse DeleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

}
