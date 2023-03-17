package com.eryckavel.spring.webflux.model.geolocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Geolocation {

    private String ip_address;
    private String city;
    private String city_geoname_id;
    private String region;
    private String region_iso_code;
    private String region_geoname_id;
    private String postal_code;
    private String country;
    private String country_code;
    private String country_geoname_id;
    private Boolean country_is_eu;
    private String continent;
    private String continent_code;
    private String continent_geoname_id;
    private Float longitude;
    private Float latitude;
    private Security security;
    private TimeZone timezone;
    private Flag flag;
    private Currency currency;
    private Connection connection;

}
