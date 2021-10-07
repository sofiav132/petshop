/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.DivisiInterface;
import com.spboot.petshop.models.Divisi;
import com.spboot.petshop.repositories.DivisiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BesariMaliik, Sofia
 */
@Service
public class DivisiService implements DivisiInterface {

    @Autowired
    private DivisiRepository divisiRepository;

    @Override
    public List<Divisi> getAll() {
        return divisiRepository.findAll();
    }
}
