package org.sid.billingservice.entities;

import lombok.Data;

@Data
public class Product {

    private Long id ;
    private String name ;
    private double price;
    private double quantity;


}