/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.AdminInterface;
import com.spboot.petshop.models.Admin;
import com.spboot.petshop.repositories.AdminRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Service
public class AdminService implements AdminInterface {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void register(Admin admin) throws Exception {
        String hashed = this.hash(admin.getPassword());
        admin.setPassword(hashed);
        
        this.adminRepository.save(admin);
    }

    @Override
    public Admin auth(String email, String password) throws Exception {
        Admin admin = adminRepository.findByEmail(email);

        if (admin == null) {
            return null;
        }

        if (!this.match(admin.getPassword(), password)) {
            return null;
        }

        return admin;
    }

    private String hash(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDiggest = md.digest(password.getBytes());

        BigInteger no = new BigInteger(1, messageDiggest);

        String hashText = no.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return hashText;
    }

    private boolean match(String password, String rawPassword)
            throws Exception {
        rawPassword = this.hash(rawPassword);
        return password.equals(rawPassword);
    }
}
