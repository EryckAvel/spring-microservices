package com.eryckavel.spring.webflux.service;

import com.eryckavel.spring.webflux.model.Endereco;
import org.springframework.http.HttpStatusCode;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class CepRestService {

    private WebClient webClient;

    public CepRestService(WebClient.Builder builder) {
        webClient = builder
                .baseUrl("https://viacep.com.br/ws/")
                .build();
    }

    public Mono<Endereco> buscarCep(String cep){
        return webClient
                .get()
                .uri(cep + "/json")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        erro -> Mono.error(new RuntimeException("Verifique os paramentros enviados!")))
                .bodyToMono(Endereco.class);

    }

}
