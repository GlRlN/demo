package com.example.demo.domain.service;

import com.example.demo.domain.model.entity.Sales;
import com.example.demo.domain.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<Sales> findByProcess(int process) {
        return salesRepository.findByProcess(process);
    }

    public List<Object[]> findSalesByProcess(int process) {
        return salesRepository.findSalesByProcess(process);
    }
}
