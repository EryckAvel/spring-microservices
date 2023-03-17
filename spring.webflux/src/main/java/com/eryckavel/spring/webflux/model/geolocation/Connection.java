package com.eryckavel.spring.webflux.model.geolocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Connection {

    private String connection_type;
    private Integer autonomous_system_number;
    private String autonomous_system_organization;
    private String isp_name;
    private String organization_name;

}
