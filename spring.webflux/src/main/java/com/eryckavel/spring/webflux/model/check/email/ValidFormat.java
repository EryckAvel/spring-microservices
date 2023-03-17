package com.eryckavel.spring.webflux.model.check.email;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ValidFormat {

    private Boolean value;
    private String text;

}
