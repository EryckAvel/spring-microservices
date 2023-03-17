package com.eryckavel.spring.webflux.model.geolocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Flag {

    private String svg;
    private String png;
    private String emoji;
    private String unicode;

}
