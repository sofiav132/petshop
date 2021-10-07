/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.interfaces;

import com.spboot.petshop.models.Product;
import java.util.List;

/**
 *
 * @author BesariMaliik, Sofia
 */
public interface ProductInterface {
    List<Product> getAll();
    void prostore(Product product);
    Product getById(long id);
    void delete(long id);
}
