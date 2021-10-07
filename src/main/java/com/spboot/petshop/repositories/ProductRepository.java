/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.repositories;

import com.spboot.petshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

