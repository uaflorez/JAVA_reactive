package com.bancolombia.user.service.inter;

import com.bancolombia.user.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface ITransactionService {
    List<Transaction> getAllTransactions();
    Optional<Transaction> getTransactionById(Long id);
    Transaction saveTransaction(Transaction transaction);
}
