/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.ProductInterface;
import com.spboot.petshop.interfaces.SupplierInterface;
import com.spboot.petshop.models.Admin;
import com.spboot.petshop.models.Product;
import com.spboot.petshop.models.Supplier;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private SupplierInterface supplierInterface;

    @GetMapping("/product")
    public String proindex(Model model,  HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        long admin_id = (long) session.getAttribute("id");
        
        List<Product> products = productInterface.findByAdminId(admin_id);
        
        model.addAttribute("products", products);
        return "product/proindex";
    }

    @GetMapping("/product/procreate")
    public String procreate(Model model) {

        List<Supplier> tbsupplier = supplierInterface.getAll();
        model.addAttribute("tbsupplier", tbsupplier);

        Product product = new Product();
        model.addAttribute("product", product);

        return "product/procreate";
    }

    @PostMapping("/product/prostore")
    public String prostore(@ModelAttribute("product") Product product, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        Admin admin = new Admin();
        admin.setId((long) session.getAttribute("id"));
        
        product.setAdmin(admin);

        productInterface.prostore(product);
        return "redirect:/product";
    }

    @GetMapping("/product/{proid}/proedit")
    public String proedit(@PathVariable(value = "id") long id, Model model) {
        List<Supplier> tbsupplier = supplierInterface.getAll();
        model.addAttribute("tbsupplier", tbsupplier);
        
        Product product = productInterface.getById(id);

        model.addAttribute("product", product);
        return "product/proedit";
    }

    @PostMapping("/product/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        productInterface.delete(id);
        return "redirect:/product";
    }

}
