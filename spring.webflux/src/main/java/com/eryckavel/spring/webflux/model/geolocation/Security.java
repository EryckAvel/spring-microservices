package com.eryckavel.spring.webflux.model.geolocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Security {

    private Boolean is_vpn;

}
