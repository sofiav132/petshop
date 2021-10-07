/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.ProductInterface;
import com.spboot.petshop.models.Product;
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
public class ProductController {
    @Autowired
    private ProductInterface productInterface;

    @GetMapping("/product")
    public String proindex(Model model) {
        model.addAttribute("list", productInterface.getAll());
        return "product/proindex";
    }

    @GetMapping("/product/procreate")
    public String procreate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        
        return "product/procreate";
    }

    @PostMapping("/product/prostore")
    public String prostore(@ModelAttribute("product") Product product) {
        productInterface.prostore(product);
        return "redirect:/product";
    }
    
    @GetMapping("/product/{proid}/proedit")
    public String proedit(@PathVariable(value = "proid") long proid, Model model) {
        Product product = productInterface.getById(proid);

        model.addAttribute("product", product);
        return "product/proedit";
    }

    @PostMapping("/product/{proid}/delete")
    public String delete(@PathVariable(value = "proid") long proid) {
        productInterface.delete(proid);
        return "redirect:/product" ;
    } 
    
}

