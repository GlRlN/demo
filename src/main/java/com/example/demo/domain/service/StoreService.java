package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.StoreRequest;
import com.example.demo.domain.model.entity.Store;
import com.example.demo.domain.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    public List<Store> findByName(String name) {
        return storeRepository.findByName(name);
    }

    public void deleteByIdx(StoreRequest storeRequest) {
        storeRepository.deleteByIdx(storeRequest.getIdx());
    }

    public void save(StoreRequest storeRequest) {
        storeRepository.save(storeRequest.toEntity());
    }
}
