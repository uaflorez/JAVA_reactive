package com.example.digitalbanking.controller;

import com.example.digitalbanking.domain.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class MainControllerTest {

    @Autowired
    WebTestClient webTestClient;


    @Test
    void processTransactions() {
        Transaction transaction = new Transaction();
        transaction.setFee(2.0);
        transaction.setAmount(100);


        webTestClient.post()
                .uri("/processTransactions")
                .bodyValue(List.of(transaction))
                .exchange()
                .expectStatus().isOk();
    }
}