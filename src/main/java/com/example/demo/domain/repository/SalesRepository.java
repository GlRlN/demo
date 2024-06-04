package com.example.demo.domain.repository;

import com.example.demo.domain.model.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
    List<Sales> findByProcess(int processId);

    @Query("SELECT s, m.name, c.name, m.stock FROM Sales s JOIN Menu m ON s.menu = m.id JOIN Category c ON s.category = c.id WHERE s.process = 0")
    List<Object[]> findSalesByProcess(@Param("process") int process);
}
