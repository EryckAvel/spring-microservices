package com.eryckavel.spring.webflux.service;

import com.eryckavel.spring.webflux.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class PersonagemService {


    private WebClient webClient;

    public PersonagemService(WebClient.Builder builder) {
        webClient = builder
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public Mono<Personagem> buscarPersonagemPorId(String id){
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        erro -> Mono.error(new RuntimeException("Verifique os paramentros enviados!")))
                .bodyToMono(Personagem.class);
    }

}
