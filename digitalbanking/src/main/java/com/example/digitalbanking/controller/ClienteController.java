package com.example.digitalbanking.controller;


import com.example.digitalbanking.model.Cliente;
import com.example.digitalbanking.repository.ClienteRepository;
import com.example.digitalbanking.service.IClienteRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private IClienteRestClient clienteRestClient;

    @GetMapping
    public Flux<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Cliente> getClienteById(@PathVariable String id) {
        return clienteRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cliente> createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Mono<Cliente> updateCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        return clienteRepository.findById(id)
                .flatMap(existingCliente -> {
                    existingCliente.setNombre(cliente.getNombre());
                    existingCliente.setCorreo(cliente.getCorreo());
                    return clienteRepository.save(existingCliente);
                });
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCliente(@PathVariable String id) {
        return clienteRepository.deleteById(id);
    }

    @GetMapping("/self/{clienteId}")
    public Mono<Cliente> getSelfClientDetails(@PathVariable String clienteId) {
        return clienteRestClient.getClientDetails(clienteId);
    }

    @PostMapping("/self")
    public Mono<Cliente> createSelfClient(@RequestBody Cliente cliente) {
        return clienteRestClient.createClient(cliente);
    }
}
