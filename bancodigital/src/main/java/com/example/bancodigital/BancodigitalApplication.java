package com.example.bancodigital;

import com.example.bancodigital.model.CreateAccountRequest;
import com.example.bancodigital.model.TransferRequest;
import com.example.bancodigital.model.UpdateAccountRequest;
import com.example.bancodigital.service.BankService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BancodigitalApplication {

	public static void main(String[] args) {

		var bankService = new BankService();

		// Obtener el saldo
		bankService.getBalance("2")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Transferir dinero
		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setFromAccount("1");
		transferRequest.setToAccount("2");
		transferRequest.setAmount(100.00);

		bankService.transferMoney(transferRequest)
				.doOnNext(result -> System.out.println(result))
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Obtener transacciones
		bankService.getTransactions("2")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Crear cuenta
		CreateAccountRequest createAccountRequest = new CreateAccountRequest();
		createAccountRequest.setAccountId("3");
		createAccountRequest.setInitialBalance(500.00);

		bankService.createAccount(createAccountRequest)
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Cerrar cuenta
		bankService.closeAccount("3")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Actualizar cuenta
		UpdateAccountRequest updateAccountRequest = new UpdateAccountRequest();
		updateAccountRequest.setAccountId("2");
		updateAccountRequest.setNewData("New Data");

		bankService.updateAccount(updateAccountRequest)
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Obtener perfil del cliente
		bankService.getCustomerProfile("2")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Obtener préstamos activos
		bankService.getActiveLoans("12345")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Simular interés compuesto
		bankService.simulateInterest("2")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();

		// Obtener estado del préstamo
		bankService.getLoanStatus("loan1")
				.doOnNext(System.out::println)
				.doOnError(throwable -> System.out.println(throwable.getMessage()))
				.subscribe();
	}
}

