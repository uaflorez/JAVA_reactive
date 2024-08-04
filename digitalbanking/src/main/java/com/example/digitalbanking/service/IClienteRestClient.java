package com.example.digitalbanking.service;
import com.example.digitalbanking.model.Cliente;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

public interface IClienteRestClient {
    @GetExchange("/clientes/{clienteId}")
    Mono<Cliente> getClientDetails(@PathVariable("clienteId") String clienteId);
    @PostExchange("/clientes")
    Mono<Cliente> createClient(Cliente cliente);
}
