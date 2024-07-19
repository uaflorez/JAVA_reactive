package com.example.transacciones.service;

import com.example.transacciones.domain.Transaction;
import com.example.transacciones.domain.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TransactionConfirmationService {

    @Autowired
    private WebClient.Builder webClient;

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
        WebClient client = webClient.baseUrl("http://localhost:8090").build();
        return client.post()
                .uri("/executeBatch")
                .bodyValue(transactions)
                .retrieve()
                .bodyToMono(Void.class)
                .then(Mono.just(transactions));

    }
}
