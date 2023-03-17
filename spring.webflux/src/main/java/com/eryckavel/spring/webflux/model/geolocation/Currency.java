package com.eryckavel.spring.webflux.model.geolocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Currency {

    private String currency_name;
    private String currency_code;

}
