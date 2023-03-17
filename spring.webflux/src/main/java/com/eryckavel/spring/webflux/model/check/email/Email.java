package com.eryckavel.spring.webflux.model.check.email;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Email {

    private String email;
    private String auto_correct;
    private String deliverability;
    private String quality_score;
    private ValidFormat is_valid_format;
    private FreeEmail is_free_email;
    private DisposableEmail is_disposable_email;
    private RoleEmail is_role_email;
    private CatchAllEmail is_catchall_email;
    private MxFound is_mx_found;
    private SmtpValid is_smtp_valid;

}
