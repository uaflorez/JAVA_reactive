package com.example.entrega.repository;

import com.example.entrega.model.Client;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {
}
