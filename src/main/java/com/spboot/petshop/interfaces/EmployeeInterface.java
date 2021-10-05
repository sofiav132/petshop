/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.interfaces;

import com.spboot.petshop.models.Employee;
import java.util.List;

/**
 *
 * @author BesariMaliik, Sofia
 */
public interface EmployeeInterface {
    List<Employee> getAll();
    void empstore(Employee employee);
    Employee getById(long id);
    void delete(long id);
}
