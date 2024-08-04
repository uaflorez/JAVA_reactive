package com.example.entrega.service;

import com.example.entrega.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientService clientService;

    @Override
    public Mono<Client> getClientById(Long id) {
        return null;
    }

    @Override
    public Mono<Client> createClient(Client client) {
        return null;
    }

    @Override
    public Mono<Client> updateClientBalance(Long id, Double amount) {
        return null;
    }
}
