/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.SupplierInterface;
import com.spboot.petshop.models.Supplier;
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
public class SupplierController {
    @Autowired
    private SupplierInterface supplierInterface;

    @GetMapping("/supplier")
    public String supindex(Model model) {
        model.addAttribute("list", supplierInterface.getAll());
        return "supplier/supindex";
    }

    @GetMapping("/supplier/supcreate")
    public String supcreate(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        
        return "supplier/supcreate";
    }

    @PostMapping("/supplier/supstore")
    public String supstore(@ModelAttribute("supplier") Supplier supplier) {
        supplierInterface.supstore(supplier);
        return "redirect:/supplier/";
    }
    
    @GetMapping("/supplier/{id}/supedit")
    public String supedit(@PathVariable(value = "id") long id, Model model) {
        Supplier supplier = supplierInterface.getById(id);

        model.addAttribute("supplier", supplier);
        return "supplier/supedit";
    }

    @PostMapping("/supplier/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        supplierInterface.delete(id);
        return "redirect:/supplier/" ;
    }
}
