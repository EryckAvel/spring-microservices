package com.eryckavel.spring.webflux.controller;

import com.eryckavel.spring.webflux.model.geolocation.Geolocation;
import com.eryckavel.spring.webflux.service.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/geolocation")
public class GeolocationController {

    @Autowired
    GeolocationService geolocationService;

    @GetMapping("/{ip}")
    public Mono<Geolocation> geolocationMono(@PathVariable("ip") String ip){
        return geolocationService.buscarGeoIp(ip);
    }

}
