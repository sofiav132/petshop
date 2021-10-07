/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.EmployeeInterface;
import com.spboot.petshop.models.Employee;
import com.spboot.petshop.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Service
public class EmployeeService implements EmployeeInterface {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void empstore(Employee employee) {
        this.employeeRepository.save(employee);
    }
    
    @Override
    public Employee getById(long id) {
        Optional < Employee > optional = employeeRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Employee not found for id : " + id);
     }

    Employee employee = optional.get();
    return employee;
    }

    @Override
    public void delete(long id) {
    this.employeeRepository.deleteById(id);
    }
    
    @Override
    public List<Employee> findByAdminId(long admin_id) {
        return employeeRepository.findByAdminId(admin_id);
    }
}
