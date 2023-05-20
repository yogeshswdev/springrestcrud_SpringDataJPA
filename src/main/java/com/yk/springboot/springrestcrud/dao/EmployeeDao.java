package com.yk.springboot.springrestcrud.dao;

import java.util.List;

import com.yk.springboot.springrestcrud.entity.Employee;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee getById(int i);

    Employee save(Employee emp);

    String delete(int i);

}
