/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.interfaces;

import com.spboot.petshop.models.Admin;

/**
 *
 * @author BesariMaliik, Sofia
 */
public interface AdminInterface {
    void register(Admin admin) throws Exception;
    Admin auth(String email, String password) throws Exception;
}
