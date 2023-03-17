package com.eryckavel.spring.webflux.controller;

import com.eryckavel.spring.webflux.model.check.email.Email;
import com.eryckavel.spring.webflux.service.CheckEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/email")
public class CheckEmailController {

    @Autowired
    CheckEmailService service;

    @GetMapping("/{email}")
    public Mono<Email> validarEmail(@PathVariable("email") String email){
        return service.validarEmail(email);
    }

}
