/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.CustomerInterface;
import com.spboot.petshop.interfaces.ProductInterface;
import com.spboot.petshop.interfaces.TransactionInterface;
import com.spboot.petshop.models.Customer;
import com.spboot.petshop.models.Product;
import com.spboot.petshop.models.Transaction;
import java.util.List;
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
    public String traindex(Model model) {
        model.addAttribute("list", transactionInterface.getAll());
        return "transaction/traindex";
    }

    @PostMapping("/transaction/trastore")
    public String trastore(@ModelAttribute("transaction") Transaction transaction) {
        transactionInterface.trastore(transaction);
        return "redirect:/transaction";
    }

}