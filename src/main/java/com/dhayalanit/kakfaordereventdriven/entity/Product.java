package com.dhayalanit.kakfaordereventdriven.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Product {
    private Long id;
    private String description;
}
