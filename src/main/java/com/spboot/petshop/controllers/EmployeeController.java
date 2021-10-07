/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.EmployeeInterface;
import com.spboot.petshop.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeInterface employeeInterface;

    @GetMapping("/employee")
    public String empindex(Model model) {
        model.addAttribute("list", employeeInterface.getAll());
        return "employee/empindex";
    }

    @GetMapping("/employee/empcreate")
    public String empcreate(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        
        return "employee/empcreate";
    }

    @PostMapping("/employee/empstore")
    public String empstore(@ModelAttribute("employee") Employee employee) {
        employeeInterface.empstore(employee);
        return "redirect:/employee";
    }
    
    @GetMapping("/employee/{id}/empedit")
    public String empedit(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeInterface.getById(id);

        model.addAttribute("employee", employee);
        return "employee/empedit";
    }

    @PostMapping("/employee/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        employeeInterface.delete(id);
        return "redirect:/employee" ;
    }
}
