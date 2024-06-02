package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KKSProductRequest {
    private long id;
    private String name;
    private int price;

    public Product toEntity() {
        Product kksProduct = new Product();

        kksProduct.setId(id);
        kksProduct.setName(name);
        kksProduct.setPrice(price);

        return kksProduct;
    }
}
