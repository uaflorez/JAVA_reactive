package com.example.entrega.service;

import com.example.entrega.model.Client;
import reactor.core.publisher.Mono;

public interface IClientService {
    Mono<Client> getClientById(Long id);
    Mono<Client> createClient(Client client);
    Mono<Client> updateClientBalance(Long id, Double amount);
}