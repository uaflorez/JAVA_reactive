package com.example.entrega.service;

import com.example.entrega.model.Cashout;
import com.example.entrega.repository.CashoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CashoutService implements ICashoutService {
    @Autowired
    private CashoutRepository cashoutRepository;

    @Autowired
    private WebClient webClient;

    public Mono<Cashout> createCashout(Cashout cashout) {
        return webClient.post()
                .uri("http://external-service/payments")
                .body(BodyInserters.fromValue(cashout))
                .retrieve()
                .bodyToMono(Void.class)
                .then(cashoutRepository.save(cashout));
    }

    public Flux<Cashout> getCashoutsByClientId(Long clientId) {
        return webClient.get()
                .uri("http://external-service/transaction-history/" + clientId)
                .retrieve()
                .bodyToFlux(Cashout.class);
    }
}