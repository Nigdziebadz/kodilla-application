package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Mail {
    private String mailTo;
    private String subject;
    private String Cc;
    private String message;


}
