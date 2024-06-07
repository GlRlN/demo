package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    void deleteById(Long Id);
}
