/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.AdminInterface;
import com.spboot.petshop.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Controller
public class RegisterController {
    @Autowired
    private AdminInterface adminInterface;

    @GetMapping("/register")
    public String index(Model model) {

        Admin admin = new Admin();
        model.addAttribute("admin", admin);

        return "register";
    }

    @PostMapping("/register")
    public String store(@ModelAttribute("admin") Admin admin) throws Exception {
        adminInterface.register(admin);
        return "redirect:/login";
    }
}
