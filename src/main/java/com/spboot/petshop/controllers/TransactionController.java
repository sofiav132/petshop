/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.CustomerInterface;
import com.spboot.petshop.interfaces.ProductInterface;
import com.spboot.petshop.interfaces.TransactionInterface;
import com.spboot.petshop.interfaces.ProductInterface;
import com.spboot.petshop.interfaces.TransactionInterface;
import com.spboot.petshop.models.Admin;
import com.spboot.petshop.models.Customer;
import com.spboot.petshop.models.Product;
import com.spboot.petshop.models.Transaction;
import com.spboot.petshop.models.Product;
import com.spboot.petshop.models.Transaction;
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
 * @author BesariMaliik
 */
@Controller
public class TransactionController {

    @Autowired
    private TransactionInterface transactionInterface;
    
    @Autowired
    private ProductInterface productInterface;
    
    @Autowired
    private CustomerInterface customerInterface;
    
    @GetMapping("/transaction")
    public String traindex(Model model,  HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        long admin_id = (long) session.getAttribute("id"); 
        List<Transaction> transactions = transactionInterface.findByAdminId(admin_id);  
        model.addAttribute("transactions", transactions);
        
        return "transaction/traindex";
    }

    @GetMapping("/transaction/tracreate")
    public String tracreate(Model model) {
        List<Product> tbproduct = productInterface.getAll();
        model.addAttribute("tbproduct", tbproduct);

        List<Customer> customer = customerInterface.getAll();
        model.addAttribute("customer", customer);

        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);

        return "transaction/tracreate";
    }

    @PostMapping("/transaction/trastore")
    public String trastore(@ModelAttribute("transaction") Transaction transaction, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        Admin admin = new Admin();
        admin.setId((long) session.getAttribute("id"));
        
        transaction.setAdmin(admin);

        transactionInterface.trastore(transaction);
        return "redirect:/transaction";
    }
    
    @GetMapping("/transaction/{id}/traedit")
    public String traedit(@PathVariable(value = "id") long id, Model model) {
        List<Product> tbproduct = productInterface.getAll();
        model.addAttribute("tbproduct", tbproduct);
        
        List<Customer> tbcustomer = customerInterface.getAll();
        model.addAttribute("tbcustomer", tbcustomer);
        
        Transaction transaction = transactionInterface.getById(id);

        model.addAttribute("transaction", transaction);
        return "transaction/traedit";
    }
    
    @PostMapping("/transaction/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        transactionInterface.delete(id);
        return "redirect:/transaction";
    }
}
