/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.interfaces;

import com.spboot.petshop.models.Admin;
import java.util.List;

/**
 *
 * @author BesariMaliik, Sofia
 */
public interface AdminInterface {
    List<Admin> getAll();
    void register(Admin admin) throws Exception;
    Admin auth(String email, String password) throws Exception;
}
