/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.CustomerInterface;
import com.spboot.petshop.models.Customer;
import com.spboot.petshop.repositories.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author BesariMaliik, Sofia
 */
@Service
public class CustomerService implements CustomerInterface {
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public void cusstore(Customer customer) {
        this.customerRepository.save(customer);
    }
    
    @Override
    public Customer getById(long custid) {
        Optional < Customer > optional = customerRepository.findById(custid);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Customer not found for id : " + custid);
     }

    Customer customer = optional.get();
    return customer;
    }

    @Override
    public void delete(long custid) {
    this.customerRepository.deleteById(custid);
    }
}