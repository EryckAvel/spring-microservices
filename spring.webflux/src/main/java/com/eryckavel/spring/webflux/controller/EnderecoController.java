package com.eryckavel.spring.webflux.controller;

import com.eryckavel.spring.webflux.model.Endereco;
import com.eryckavel.spring.webflux.service.CepRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private CepRestService service;

    @GetMapping("/{cep}")
    public Mono<Endereco> buscarCep(@PathVariable("cep") String cep){
        return service.buscarCep(cep);
    }

}
