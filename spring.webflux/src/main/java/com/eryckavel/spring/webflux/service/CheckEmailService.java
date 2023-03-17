package com.eryckavel.spring.webflux.service;

import com.eryckavel.spring.webflux.model.check.email.Email;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.Semaphore;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class CheckEmailService {

    private WebClient webClient;

    public CheckEmailService(WebClient.Builder builder) {
        webClient = builder
                .baseUrl("https://emailvalidation.abstractapi.com/v1/")
                .build();
    }

    public Mono<Email> validarEmail(String email){
        return webClient
                .get()
                .uri("/?api_key=ea3fd3d7db27415196065146ecf707d2&email=" + email)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        erro -> Mono.error(new RuntimeException("Verifique os paramentros enviados!")))
                .bodyToMono(Email.class);
    }

}
