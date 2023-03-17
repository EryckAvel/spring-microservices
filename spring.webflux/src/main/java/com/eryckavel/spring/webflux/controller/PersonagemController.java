package com.eryckavel.spring.webflux.controller;

import com.eryckavel.spring.webflux.model.Personagem;
import com.eryckavel.spring.webflux.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    PersonagemService service;

    @GetMapping("/{id}")
    public Mono<Personagem> buscarPersonagem(@PathVariable("id") String id){
        return service.buscarPersonagemPorId(id);
    }

}
