package com.yk.springboot.springrestcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yk.springboot.springrestcrud.entity.Employee;
//use copilot
import com.yk.springboot.springrestcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAll() {

        return employeeService.getAll();

    }

    @GetMapping("/employee/{employeeId}")
    public Employee getById(@PathVariable int employeeId) {
        Employee employee = employeeService.getById(employeeId);
        return employee;
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee emp) {
        emp.setId(0);
        Employee employee = employeeService.save(emp);
        return employee;
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee emp) {
        Employee employee = employeeService.update(emp);
        return employee;
    }

    @DeleteMapping("/employee/{employeeId}")
    public String delete(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.getById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("The given employee id not exist" + employeeId);
        }
        employeeService.delete(employeeId);
        return "Deleted employee id" + employeeId;
    }

}
