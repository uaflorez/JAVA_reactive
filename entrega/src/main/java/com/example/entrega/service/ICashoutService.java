package com.example.entrega.service;

import com.example.entrega.model.Cashout;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICashoutService {
    Mono<Cashout> createCashout(Cashout cashout);
    Flux<Cashout> getCashoutsByClientId(Long clientId);
}