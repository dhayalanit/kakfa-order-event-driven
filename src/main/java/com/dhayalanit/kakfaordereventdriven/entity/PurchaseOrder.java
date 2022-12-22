package com.dhayalanit.kakfaordereventdriven.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class PurchaseOrder {
    @Id
    private Long id;
    private User user;
    private Product product;
    private double price;
}
