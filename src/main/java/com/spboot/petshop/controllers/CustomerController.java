/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.CustomerInterface;
import com.spboot.petshop.models.Customer;
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
public class CustomerController {
    @Autowired
    private CustomerInterface customerInterface;

    @GetMapping("/customer")
    public String cusindex(Model model) {
        model.addAttribute("list", customerInterface.getAll());
        return "customer/cusindex";
    }

    @GetMapping("/customer/cuscreate")
    public String cuscreate(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        
        return "customer/cuscreate";
    }

    @PostMapping("/customer/cusstore")
    public String cusstore(@ModelAttribute("customer") Customer customer) {
        customerInterface.cusstore(customer);
        return "redirect:/customer";
    }
    
    @GetMapping("/customer/{custid}/cusedit")
    public String cusedit(@PathVariable(value = "custid") long custid, Model model) {
        Customer customer = customerInterface.getById(custid);

        model.addAttribute("customer", customer);
        return "customer/cusedit";
    }

    @PostMapping("/customer/{custid}/delete")
    public String delete(@PathVariable(value = "custid") long custid) {
        customerInterface.delete(custid);
        return "redirect:/customer" ;
    } 
    
}
