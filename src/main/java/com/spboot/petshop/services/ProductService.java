/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.ProductInterface;
import com.spboot.petshop.models.Product;
import com.spboot.petshop.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Service
public class ProductService implements ProductInterface {
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void prostore(Product product) {
        this.productRepository.save(product);
    }
    
    @Override
    public Product getById(long proid) {
        Optional < Product > optional = productRepository.findById(proid);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Product not found for id : " + proid);
     }

    Product product = optional.get();
    return product;
    }

    @Override
    public void delete(long proid) {
    this.productRepository.deleteById(proid);
    }
    
    @Override
    public List<Product> findByAdminId(long admin_id) {
        return productRepository.findByAdminId(admin_id);
    }
}
