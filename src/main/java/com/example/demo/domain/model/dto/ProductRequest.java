package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private long id;
    private String name;
    private int price;

    public Product toEntity(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
