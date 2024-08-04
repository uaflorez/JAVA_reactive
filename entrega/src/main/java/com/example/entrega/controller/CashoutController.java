package com.example.entrega.controller;

import com.example.entrega.model.Cashout;
import com.example.entrega.service.CashoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cashouts")
public class CashoutController {
    @Autowired
    private CashoutService cashoutService;

    @PostMapping
    public Mono<Cashout> createCashout(@RequestBody Cashout cashout) {
        return cashoutService.createCashout(cashout);
    }

    @GetMapping("/client/{clientId}")
    public Flux<Cashout> getCashoutsByClientId(@PathVariable Long clientId) {
        return cashoutService.getCashoutsByClientId(clientId);
    }
}