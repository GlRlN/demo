package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    List<Store> findByName(String name);

    @Transactional
    void deleteByIdx(int idx);
}
