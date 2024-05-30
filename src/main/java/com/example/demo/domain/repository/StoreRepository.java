package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findByName(String name);
}
