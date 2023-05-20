package com.yk.springboot.springrestcrud.service;

import java.util.List;

import com.yk.springboot.springrestcrud.entity.Employee;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    Employee save(Employee emp);

    Employee update(Employee emp);

    String delete(int id);

}
