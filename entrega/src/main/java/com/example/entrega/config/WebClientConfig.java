package com.example.entrega.config;

import com.example.entrega.exception.Exception400;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient buildWebClient(WebClient.Builder webClient) {
        return webClient
                .baseUrl("http://localhost:8090")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, clientResponse -> {
                    return clientResponse.bodyToMono(String.class)
                            .flatMap(errorBody -> Mono.error(new Exception400(errorBody)));
                })
                // .defaultStatusHandler(HttpStatusCode::is5xxServerError, clientResponse -> {})
                .build();
    }
}