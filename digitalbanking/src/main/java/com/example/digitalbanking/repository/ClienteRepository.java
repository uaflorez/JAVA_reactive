package com.example.digitalbanking.repository;


import com.example.digitalbanking.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends ReactiveMongoRepository<Cliente, String> {
}
