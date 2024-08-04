package com.example.entrega.repository;

import com.example.entrega.model.Cashout;
import com.example.entrega.model.Client;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface CashoutRepository extends ReactiveCrudRepository<Cashout, Long> {
    Flux<Cashout> findByClient(Long clientId);
}
