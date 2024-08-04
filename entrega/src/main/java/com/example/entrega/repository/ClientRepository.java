package com.example.entrega.repository;

import com.example.entrega.model.Client;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ReactiveMongoClientFactory<Client, Long> {
}