package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ItemLine {
    private Product product;
    private int quantity;
    private double price;
    public ItemLine(Product product){
        this.product = product;
        this.price = product.getPrice();
    }
}
