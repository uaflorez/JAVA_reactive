package com.example.entrega.service;

import com.example.entrega.model.Cashout;
import com.example.entrega.repository.CashoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ICashoutService implements CashoutService {
    @Autowired
    private CashoutRepository cashoutRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<Cashout> createCashout(Cashout cashout) {
        // Lógica para llamar al microservicio de pagos y verificar el cashout
        return webClient.post()
                .uri("http://external-service/payments")
                .body(BodyInserters.fromValue(cashout))
                .retrieve()
                .bodyToMono(Void.class)
                .then(cashoutRepository.save(cashout));
    }

    @Override
    public Flux<Cashout> getCashoutsByUserId(Long userId) {
        // Lógica para llamar al microservicio de historial de transacciones
        return webClient.get()
                .uri("http://external-service/transaction-history/" + userId)
                .retrieve()
                .bodyToFlux(Cashout.class);
    }
}