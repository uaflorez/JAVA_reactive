package com.example.entrega.service;

import com.example.entrega.model.Cashout;
import com.example.entrega.payload.PaymentResponse;
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

    @Override
    public Mono<Cashout> createCashout(Cashout cashout) {
        return webClient.post()
                .uri("http://external-service/payments/verify")
                .body(BodyInserters.fromValue(cashout))
                .retrieve()
                .bodyToMono(PaymentResponse.class)  // Suponiendo que PaymentResponse es la clase que modela la respuesta del microservicio
                .flatMap(paymentResponse -> {
                    if (paymentResponse.isApproved()) { // Si el pago es aprobado
                        // Aquí puedes realizar cualquier otra acción necesaria antes de guardar el cashout
                        return cashoutRepository.save(cashout);
                    } else {
                        return Mono.error(new RuntimeException("Payment not approved"));
                    }
                })
                .onErrorResume(error -> {
                    // Manejo de errores, si el microservicio de pagos falla o devuelve un error
                    return Mono.error(new RuntimeException("Error processing payment: " + error.getMessage()));
                });
    }
    @Override
    public Flux<Cashout> getCashoutsByClientId(Long clientId) {
        return webClient.get()
                .uri("http://external-service/transaction-history/" + clientId)
                .retrieve()
                .bodyToFlux(Cashout.class);
    }
}


