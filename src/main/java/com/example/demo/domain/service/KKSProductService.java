package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.KKSProductRequest;
import com.example.demo.domain.model.entity.Product;
import com.example.demo.domain.repository.KKSProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KKSProductService {
    KKSProductRepository kksProductRepository;

    public KKSProductService(KKSProductRepository kksProductRepository) {
        this.kksProductRepository = kksProductRepository;
    }

    public List<Product> findAll() {
        return kksProductRepository.findAll();
    }

    public void save(KKSProductRequest kksProductRequest) {
        kksProductRepository.save(kksProductRequest.toEntity());
    }

    public Product findById(Long id) {
        return kksProductRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        kksProductRepository.deleteById(id);
    }
}
