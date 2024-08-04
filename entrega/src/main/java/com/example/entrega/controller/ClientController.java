package com.example.entrega.controller;

import com.example.entrega.model.Client;
import com.example.entrega.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Client>> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Client> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}/balance")
    public Mono<Client> updateClientBalance(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        return clientService.updateClientBalance(id, request.get("amount"));
    }

}


