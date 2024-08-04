package com.example.entrega.service;

import com.example.entrega.model.Client;
import com.example.entrega.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Mono<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    public Mono<Client> updateClientBalance(Long id, Double amount) {
        return clientRepository.findById(id)
                .flatMap(client -> {
                    client.setBalance(client.getBalance() + amount);
                    return clientRepository.save(client);
                });
    }
}