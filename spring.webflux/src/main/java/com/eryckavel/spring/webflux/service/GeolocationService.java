package com.eryckavel.spring.webflux.service;

import com.eryckavel.spring.webflux.model.geolocation.Geolocation;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class GeolocationService {

    private WebClient webClient;

    public GeolocationService(WebClient.Builder builder) {
        webClient = builder
                .baseUrl("https://ipgeolocation.abstractapi.com/v1")
                .build();
    }

    public Mono<Geolocation> buscarGeoIp(String ip){
        return webClient
                .get()
                .uri("/?api_key=6d79b07891524e758a83901b9e53872b&ip_address=" + ip)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        erro -> Mono.error(new RuntimeException("Verifique os paramentros enviados!")))
                .bodyToMono(Geolocation.class);
    }

}
