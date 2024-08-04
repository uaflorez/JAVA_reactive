package com.bancolombia.user.service;

import com.bancolombia.user.entity.Transaction;
import com.bancolombia.user.repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public List<Transaction> getAllTransaction(){
        return transactionRepository.findAll();
    }
    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
