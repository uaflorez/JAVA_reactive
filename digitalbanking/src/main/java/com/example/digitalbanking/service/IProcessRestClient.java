package com.example.digitalbanking.service;

import com.example.digitalbanking.domain.Transaction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IProcessRestClient {
    @PostExchange("/executeBatch")
    Mono<Void> processBatch(@RequestBody List<Transaction> transactions);

    @PostExchange("/calculateFees")
    Mono<Transaction> processFee(@RequestBody  Transaction transaction);
}
