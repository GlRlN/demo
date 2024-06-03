package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductRequest {
    private long id;
    private String name;
    private int price;
    private int quantity;
    private MultipartFile image;

    public Product toEntity(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
    public Product toEntity(String image){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setImage(image);
        return product;
    }
}
