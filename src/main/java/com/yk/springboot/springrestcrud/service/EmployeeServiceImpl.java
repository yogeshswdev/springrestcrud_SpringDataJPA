package com.yk.springboot.springrestcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.springboot.springrestcrud.dao.EmployeeRepository;
import com.yk.springboot.springrestcrud.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not found id of " + id);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employee update(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
