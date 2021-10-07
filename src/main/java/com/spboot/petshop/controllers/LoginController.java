/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.controllers;

import com.spboot.petshop.interfaces.AdminInterface;
import com.spboot.petshop.models.Admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Controller
public class LoginController {
   @Autowired
    private AdminInterface adminInterface;

    @GetMapping("/login")
    public String index(Model model) {

        Admin admin = new Admin();
        model.addAttribute("admin", admin);

        return "login";
    }

    @PostMapping("/login")
    public String store(@ModelAttribute("admin") Admin admin,
        HttpServletRequest request, RedirectAttributes ra) throws Exception {
        HttpSession session = request.getSession(true);

        Admin obj = adminInterface.auth(admin.getEmail(), admin.getPassword());

        if (obj == null) {
            ra.addFlashAttribute("error", "Invalid adminname or password!");
            return "redirect:/login";
        }

        session.setAttribute("id", obj.getId());
        session.setAttribute("email", obj.getEmail());
        session.setAttribute("name", obj.getName());
        session.setAttribute("loggedIn", true);

        return "redirect:/";
    }
}
