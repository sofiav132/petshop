/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.services;

import com.spboot.petshop.interfaces.TransactionInterface;
import com.spboot.petshop.interfaces.TransactionInterface;
import com.spboot.petshop.models.Transaction;
import com.spboot.petshop.models.Transaction;
import com.spboot.petshop.repositories.TransactionRepository;
import com.spboot.petshop.repositories.TransactionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class TransactionService implements TransactionInterface {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public void trastore(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }
    
    @Override
    public Transaction getById(long id) {
        Optional < Transaction > optional = transactionRepository.findById(id);

     if (!optional.isPresent()) {
        throw new RuntimeException(" Transaction not found for id : " + id);
     }

    Transaction transaction = optional.get();
    return transaction;
    }

    @Override
    public void delete(long id) {
    this.transactionRepository.deleteById(id);
    }
    
    @Override
    public List<Transaction> findByAdminId(long admin_id) {
        return transactionRepository.findByAdminId(admin_id);
    }
}
