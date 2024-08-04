package com.example.entrega.controller;

import com.example.entrega.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientController {

    @Autowired
    private ClientService clientService;

}
@Autowired
private UserService userService;

@GetMapping("/{id}")
public Mono<ResponseEntity<User>> getUserById(@PathVariable Long id) {
    return userService.getUserById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
}

@PostMapping
public Mono<User> createUser(@RequestBody User user) {
    return userService.createUser(user);
}

@PutMapping("/{id}/balance")
public Mono<User> updateUserBalance(@PathVariable Long id, @RequestBody Map<String, Double> request) {
    return userService.updateUserBalance(id, request.get("amount"));
}