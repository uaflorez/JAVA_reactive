package com.example.entrega.repository;

import com.example.entrega.model.Cashout;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CashoutRepository extends ReactiveMongoRepository<Cashout, String> {

    Flux<Cashout> findByUserId(Long clientId);
}