package com.example.entrega;

import com.example.entrega.model.Client;
import com.example.entrega.repository.ClientRepository;
import com.example.entrega.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class ClientServiceTests {
	@Autowired
	private ClientService clientService;

	@MockBean
	private ClientRepository userRepository;

	@Test
	public void testGetClientById() {
		Client client = new Client(1L, "John Doe", 100.0);
		Mockito.when(userRepository.findById(1L)).thenReturn(Mono.just(client));

		StepVerifier.create(clientService.getClientById(1L))
				.expectNextMatches(u -> u.getName().equals("John Doe"))
				.verifyComplete();
	}
}