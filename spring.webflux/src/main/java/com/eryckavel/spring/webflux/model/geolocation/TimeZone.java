package com.eryckavel.spring.webflux.model.geolocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TimeZone {

    private String name;
    private String abbreviation;
    private String gmt_offset;
    private String current_time;
    private Boolean is_dst;


}
