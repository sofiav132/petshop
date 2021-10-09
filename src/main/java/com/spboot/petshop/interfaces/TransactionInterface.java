/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spboot.petshop.interfaces;

import com.spboot.petshop.models.Transaction;
import java.util.List;

/**
 *
 * @author BesariMaliik, Sofia
 */
public interface TransactionInterface {
    List<Transaction> getAll();
    List<Transaction> findByAdminId(long admin_id);
    void trastore(Transaction transaction);
    Transaction getById(long id);
    void delete(long id);
}
