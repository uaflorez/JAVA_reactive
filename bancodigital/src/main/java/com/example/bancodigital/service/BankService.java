package com.example.bancodigital.service;

import com.example.bancodigital.exception.BusinessException;
import com.example.bancodigital.model.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.util.Arrays;
import java.util.List;

import static java.util.Locale.filter;

@Service
public class BankService {

    private final Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();

    public Mono<Double> getBalance(String accountId) {
        // Caso de uso: Consultar el saldo actual de una cuenta bancaria. Sino hay balance se debe tener un valor de 0.0
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", "2", 200.00),
                new Transaction("2", "2", -150.00),
                new Transaction("3", "2", 300.00)
        );

        return Flux.fromIterable(transactions)
                .filter(transaction -> transaction.getTransactionId().equals(accountId))
                .switchIfEmpty(Mono.error(new BusinessException("No existe la cuenta")))
                .collectList()
                .map(transactions1 -> transactions1.stream()
                        .map(Transaction::getAmount)
                        .reduce(0.0, Double::sum));
    }

    public Mono<String> transferMoney(TransferRequest request) {
        // Caso de uso: Transferir dinero de una cuenta a otra. Hacer llamado de otro flujo simulando el llamado
        return Mono.just(request)
                .flatMap(req -> {
                    if (req.getFromAccount().isEmpty() || req.getToAccount().isEmpty()) {
                        return Mono.error(new BusinessException("Cuenta origen o destino no especificada"));
                    }
                    return Mono.just("Transferencia exitosa de " + req.getFromAccount() + " a " + req.getToAccount());
                });
    }

    public Flux<Transaction> getTransactions(String accountId) {
        // Caso de uso: Consultar el historial de transacciones de una cuenta bancaria.
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", accountId, 200.00),
                new Transaction("2", accountId, -150.00),
                new Transaction("3", accountId, 300.00)
        );
        return Flux.fromIterable(transactions)
                .switchIfEmpty(Mono.error(new BusinessException("No existen transacciones para la cuenta")));
    }

    public Mono<String> createAccount(CreateAccountRequest request) {
        // Caso de uso: Crear una nueva cuenta bancaria con un saldo inicial.
        return Mono.just(request)
                .flatMap(r -> {
                    return Mono.fromCallable(r::getAccountId)
                            .switchIfEmpty(Mono.error(new BusinessException("El id de la cuanta no existe")))
                            .flatMap(id -> Mono.just(new CustomerProfile("1","uriel","uf@algo.com")));
                }).map(CustomerProfile::getCustomerId);

    }

    public Mono<String> closeAccount(String accountId) {
        // Caso de uso: Cerrar una cuenta bancaria especificada. Verificar que la ceunta exista y si no existe debe retornar un error controlado
        return Mono.just(accountId)
                .flatMap(id -> {
                    if (id.isEmpty()) {
                        return Mono.error(new BusinessException("El id de la cuenta no existe"));
                    }
                    return Mono.just("Cuenta cerrada: " + id);
                })
                .onErrorResume(e -> Mono.error(new BusinessException("Error al cerrar la cuenta: " + e.getMessage())));
    }

    public Mono<String> updateAccount(UpdateAccountRequest request) {
        // Caso de uso: Actualizar la información de una cuenta bancaria especificada. Verificar que la ceunta exista y si no existe debe retornar un error controlado
        return Mono.just(request)
                .flatMap(r -> Mono.fromCallable(r::getAccountId)
                        .switchIfEmpty(Mono.error(new BusinessException("El id de la cuenta no existe")))
                        .flatMap(id -> Mono.just("Cuenta actualizada: " + id)))
                .onErrorResume(e -> Mono.error(new BusinessException("Error al actualizar la cuenta: " + e.getMessage())));
    }

    public Mono<CustomerProfile> getCustomerProfile(String accountId) {
        // Caso de uso: Consultar el perfil del cliente que posee la cuenta bancaria. Obtener los valores por cada uno de los flujos y si no existe alguno debe presentar un error
        return Mono.just(accountId)
                .flatMap(id -> {
                    Mono<String> customerIdMono = Mono.just("12345");
                    Mono<String> nameMono = Mono.just("John Doe");
                    Mono<String> emailMono = Mono.just("john.doe@example.com");

                    return Mono.zip(customerIdMono, nameMono, emailMono)
                            .map(tuple -> new CustomerProfile(tuple.getT1(), tuple.getT2(), tuple.getT3()))
                            .switchIfEmpty(Mono.error(new BusinessException("No se encontró el perfil del cliente")));
                })
                .onErrorResume(e -> Mono.error(new BusinessException("Error al obtener el perfil del cliente: " + e.getMessage())));
    }

    public Flux<Loan> getActiveLoans(String customerId) {
        // Caso de uso: Consultar todos los préstamos activos asociados al cliente especificado.
        List<Loan> loans = Arrays.asList(
                new Loan("loan1", 5000.00, 0.05),
                new Loan("loan2", 10000.00, 0.04)
        );
        return Mono.just(customerId)
                .flatMapMany(id -> Flux.fromIterable(loans)
                        .switchIfEmpty(Mono.error(new BusinessException("No existen préstamos activos para el cliente"))))
                .onErrorResume(e -> Flux.error(new BusinessException("Error al obtener los préstamos activos: " + e.getMessage())));

    }

    public Flux<Double> simulateInterest(String accountId) {
        double principal = 1000.00;
        double rate = 0.05;

        // Caso de uso: Simular el interés compuesto en una cuenta bancaria. Sacar un rago de 10 años y aplicar la siguiente formula = principal * Math.pow(1 + rate, year)
        return Mono.just(accountId)
                .flatMapMany(id -> Flux.range(1, 10)
                        .map(year -> principal * Math.pow(1 + rate, year))
                        .switchIfEmpty(Mono.error(new BusinessException("No se pudo simular el interés"))))
                .onErrorResume(e -> Flux.error(new BusinessException("Error al simular el interés: " + e.getMessage())));

    }

    public Mono<String> getLoanStatus(String loanId) {
        // Caso de uso: Consultar el estado de un préstamo. se debe tener un flujo balanceMono y interestRateMono. Imprimir con el formato siguiente el resultado   "Loan ID: %s, Balance: %.2f, Interest Rate: %.2f%%"
        Mono<Double> balanceMono = Mono.just(5000.00);
        Mono<Double> interestRateMono = Mono.just(0.05);

        return Mono.zip(balanceMono, interestRateMono)
                .map(tuple -> String.format("Loan ID: %s, Balance: %.2f, Interest Rate: %.2f%%", loanId, tuple.getT1(), tuple.getT2() * 100))
                .switchIfEmpty(Mono.error(new BusinessException("Préstamo no encontrado")))
                .onErrorResume(e -> Mono.error(new BusinessException("Error al obtener el estado del préstamo: " + e.getMessage())));
    }


}