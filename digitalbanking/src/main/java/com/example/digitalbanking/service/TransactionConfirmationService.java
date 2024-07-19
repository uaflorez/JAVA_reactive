package com.example.digitalbanking.service;

import com.example.digitalbanking.domain.Transaction;
import com.example.digitalbanking.domain.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TransactionConfirmationService {

    @Autowired
    private IProcessRestClient client;

    @Autowired
    private TransactionRepository repository;

    public Mono<Void> confirmTransactions(Flux<Transaction> transactions){
        return transactions
                .buffer(10)
                .flatMap(this::executeTransactions)
                .flatMap(repository::saveAll)
                .then();
    }

    private Mono<List<Transaction>> executeTransactions(List<Transaction> transactions) {
        return client.processBatch(transactions).then(Mono.just(transactions));

    }
}
