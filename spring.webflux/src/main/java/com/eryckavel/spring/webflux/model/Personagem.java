package com.eryckavel.spring.webflux.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Personagem {

    private String id;
    private String name;
    private String Status;
    private String species;
    private String image;
    private List<String> episode;

}
