package com.yk.springboot.springrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.springboot.springrestcrud.dao.EmployeeDao;
import com.yk.springboot.springrestcrud.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee emp) {
        return employeeDao.save(emp);
    }

    @Override
    @Transactional
    public Employee update(Employee emp) {
        return employeeDao.save(emp);
    }

    @Override
    @Transactional
    public String delete(int id) {
        return employeeDao.delete(id);
    }

}
