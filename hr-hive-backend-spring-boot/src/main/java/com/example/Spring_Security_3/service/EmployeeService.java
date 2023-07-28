package com.example.Spring_Security_3.service;

import com.example.Spring_Security_3.entity.Employee;
import com.example.Spring_Security_3.entity.UserEntity;
import com.example.Spring_Security_3.payload.DeleteResponse;
import com.example.Spring_Security_3.repository.EmployeeRepository;
import com.example.Spring_Security_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAllEmployee(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployee(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public DeleteResponse deleteEmployee(int id){
        employeeRepository.deleteById(id);
        DeleteResponse deleteResponse=new DeleteResponse();
        deleteResponse.setMessage("User deleted successfully");
        return deleteResponse;
    }

    public Employee updatedEmployee(int id,Employee employee){
        Employee newEmployee= employeeRepository.findById(id).orElse(null);
        newEmployee.setId(id);
        newEmployee.setName(employee.getName());
        newEmployee.setEmailId(employee.getEmailId());
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        newEmployee.setDesignation(employee.getDesignation());
        newEmployee.setAddress(employee.getAddress());
        newEmployee.setGender(employee.getGender());
        return  employeeRepository.save(newEmployee);
    }

}
