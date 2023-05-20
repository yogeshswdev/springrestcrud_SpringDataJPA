package com.yk.springboot.springrestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yk.springboot.springrestcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
