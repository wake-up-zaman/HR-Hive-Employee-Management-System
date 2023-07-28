package com.example.Spring_Security_3.repository;

import com.example.Spring_Security_3.entity.Employee;
import com.example.Spring_Security_3.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
