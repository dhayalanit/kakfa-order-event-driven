package com.dhayalanit.kakfaordereventdriven.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;

}
