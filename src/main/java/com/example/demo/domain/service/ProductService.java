package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.ProductRequest;
import com.example.demo.domain.model.entity.Product;
import com.example.demo.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
            return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void save(ProductRequest productRequest) {
        productRepository.save(productRequest.toEntity());
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
