/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.SupplierInterface;
import com.spboot.petshop.models.Supplier;
import com.spboot.petshop.repositories.SupplierRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author BesariMaliik, Sofia
 */
@Service
public class SupplierService implements SupplierInterface {
   @Autowired
    private SupplierRepository supplierRepository;
    
    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public void supstore(Supplier supplier) {
        this.supplierRepository.save(supplier);
    }
    
    @Override
    public Supplier getById(long id) {
        Optional < Supplier > optional = supplierRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Supplier not found for id : " + id);
     }

    Supplier supplier = optional.get();
    return supplier;
    }

    @Override
    public void delete(long id) {
    this.supplierRepository.deleteById(id);
    } 
}
