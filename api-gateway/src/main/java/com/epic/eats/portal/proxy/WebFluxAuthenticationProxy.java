package com.epic.eats.portal.proxy;

import com.epic.eats.portal.dtos.AuthRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class WebFluxAuthenticationProxy {

    private WebClient.Builder webClientBuilder;

    public WebFluxAuthenticationProxy(WebClient.Builder webClientBuilder) {

        this.webClientBuilder = webClientBuilder;
    }

    public Mono<String> getToken(AuthRequest authRequest) {
        return webClientBuilder
                .build()
                .post() // Use POST method
                .uri("http://user-service/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(authRequest)
                .retrieve()
                .bodyToMono(String.class)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Boolean> validateToken(String token) {
        return webClientBuilder.build().get()
                .uri("http://user-service/users/validate?token=" + token)
                .retrieve()
                .bodyToMono(Boolean.class)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
